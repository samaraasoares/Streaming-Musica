import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Musica> bancoDeMusicas = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        int opcao = -1;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING (CP5 - FINALIZADO) ===");
            if (usuarioLogado == null) {
                System.out.println("1. Criar novo usuário");
                System.out.println("2. Login");
                System.out.println("3. Ver Estatísticas do Sistema");
            } else {
                String tipo = (usuarioLogado instanceof UsuarioPremium) ? "Premium" : "Free";
                System.out.println(" Logado como: " + usuarioLogado.getNome() + " [" + tipo + "]");
                System.out.println("4. Ouvir Música");
                System.out.println("5. Gerenciar Playlists");
                System.out.println("6. Logout");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> criarUsuario();
                    case 2 -> realizarLogin();
                    case 3 -> exibirEstatisticas();
                    case 4 -> reproduzirAlgo();
                    case 5 -> gerenciarPlaylists();
                    case 6 -> { usuarioLogado = null; System.out.println(" Logout efetuado."); }
                    case 0 -> System.out.println("Encerrando sistema...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println(" Erro de entrada. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirEstatisticas() {
        int qtdFree = 0, qtdPremium = 0;
        int reprodFree = 0, reprodPremium = 0;
        
        System.out.println("\n=== RELATÓRIO DE USO DO SISTEMA ===");
        for (Usuario u : usuarios) {
            if (u instanceof UsuarioFree) {
                qtdFree++;
                reprodFree += u.getReproducoesIndividuais();
            } else if (u instanceof UsuarioPremium) {
                qtdPremium++;
                reprodPremium += u.getReproducoesIndividuais();

                System.out.println("-> Assinante: " + u.getNome() + " (Plano " + ((UsuarioPremium) u).getTipoPlano() + ")");
            }
        }
        
        int totalReprod = Usuario.totalReproducoesSistema;
        double percFree = (totalReprod > 0) ? (reprodFree * 100.0 / totalReprod) : 0;
        double percPremium = (totalReprod > 0) ? (reprodPremium * 100.0 / totalReprod) : 0;

        System.out.println("------------------------------------");
        System.out.println("Contas: " + qtdFree + " Free | " + qtdPremium + " Premium");
        System.out.println("Reproduções Totais: " + totalReprod);
        System.out.printf("- Uso Free: %d (%.1f%%)\n", reprodFree, percFree);
        System.out.printf("- Uso Premium: %d (%.1f%%)\n", reprodPremium, percPremium);
        System.out.println("Anúncios exibidos: " + UsuarioFree.totalAnunciosExibidos);
        System.out.println("------------------------------------");
    }


    private static void inicializarDados() {
        bancoDeMusicas.add(new Musica("Flowers", "Miley Cyrus", 200, "Pop"));
        bancoDeMusicas.add(new Musica("Equalize", "Pitty", 210, "Rock"));
        bancoDeMusicas.add(new Musica("In the End", "Linkin Park", 216, "Rock"));
    }

    private static void realizarLogin() {
        if (usuarios.isEmpty()) { System.out.println(" Nenhum usuário cadastrado."); return; }
        System.out.println("\n--- LOGIN ---");
        for (int i = 0; i < usuarios.size(); i++) { System.out.println(i + ". " + usuarios.get(i).getNome()); }
        System.out.print("Escolha seu usuário: ");
        int esc = Integer.parseInt(scanner.nextLine());
        if (esc >= 0 && esc < usuarios.size()) {
            usuarioLogado = usuarios.get(esc);
            System.out.println(" Bem-vindo, " + usuarioLogado.getNome());
        }
    }

    private static void criarUsuario() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Tipo (1. Free | 2. Premium): ");
        int tipo = Integer.parseInt(scanner.nextLine());
        if (tipo == 2) {
            System.out.print("Plano (Mensal/Anual): "); String plano = scanner.nextLine();
            usuarios.add(new UsuarioPremium(nome, email, plano));
        } else { usuarios.add(new UsuarioFree(nome, email)); }
        System.out.println(" Cadastro concluído!");
    }

    private static void reproduzirAlgo() {
        if (usuarioLogado == null) return;
        for (int i = 0; i < bancoDeMusicas.size(); i++) {
            System.out.println(i + ". " + bancoDeMusicas.get(i).getTitulo());
        }
        System.out.print("Escolha a música: ");
        int mIdx = Integer.parseInt(scanner.nextLine());
        if (mIdx >= 0 && mIdx < bancoDeMusicas.size()) {
            Musica m = bancoDeMusicas.get(mIdx);
            usuarioLogado.reproduzirMusica(m);
            if (usuarioLogado instanceof UsuarioPremium) {
                System.out.print("Baixar música? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) ((UsuarioPremium) usuarioLogado).baixarMusica(m);
            }
        }
    }

    private static void gerenciarPlaylists() {
        if (usuarioLogado == null) return;
        System.out.println("\n1. Nova Playlist | 2. Playlist Auto (Gênero) | 3. Ver Minhas Playlists");
        int sub = Integer.parseInt(scanner.nextLine());
        if (sub == 1 || sub == 2) {
            System.out.print("Nome: "); String nome = scanner.nextLine();
            if (sub == 2) {
                System.out.print("Gênero: "); String crit = scanner.nextLine();
                PlaylistAutomatica pa = new PlaylistAutomatica(nome, crit);
                pa.atualizar(bancoDeMusicas);
                usuarioLogado.adicionarPlaylist(pa);
            } else {
                System.out.print("Desc: "); String desc = scanner.nextLine();
                usuarioLogado.adicionarPlaylist(new PlaylistPersonalizada(nome, desc));
            }
        } else if (sub == 3) {
            if (usuarioLogado.getPlaylists().isEmpty()) System.out.println("Vazia.");
            else for (Playlist p : usuarioLogado.getPlaylists()) p.reproduzir();
        }
    }
}
