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
            System.out.println("\n=== SISTEMA DE STREAMING (CP5 - ATUALIZADO) ===");
            
            if (usuarioLogado == null) {
                System.out.println("1. Criar novo usuário");
                System.out.println("2. Login");
                System.out.println("3. Ver Estatísticas Detalhadas");
            } else {
                String tipo = (usuarioLogado instanceof UsuarioPremium) ? "Premium" : "Free";
                System.out.println(" Usuário: " + usuarioLogado.getNome() + " [" + tipo + "]");
                System.out.println("4. Ouvir Música");
                System.out.println("5. Gerenciar Playlists");
                System.out.println("6. Logout");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; 
            }

            switch (opcao) {
                case 1 -> criarUsuario();
                case 2 -> realizarLogin();
                case 3 -> exibirEstatisticas();
                case 4 -> reproduzirAlgo();
                case 5 -> gerenciarPlaylists();
                case 6 -> {
                    usuarioLogado = null;
                    System.out.println(" Logout efetuado.");
                }
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida! Digite um número do menu.");
            }
        } while (opcao != 0);
    }

    private static void exibirEstatisticas() {
        int qtdFree = 0, qtdPremium = 0;
        System.out.println("\n=== ESTATÍSTICAS GERAIS DO SISTEMA ===");
        
        for (Usuario u : usuarios) {
            if (u instanceof UsuarioFree) {
                qtdFree++;
            } else if (u instanceof UsuarioPremium) {
                qtdPremium++;
                UsuarioPremium up = (UsuarioPremium) u;
                System.out.println("-> Assinante: " + up.getNome() + " (Plano " + up.getTipoPlano() + ")");
            }
        }
        
        System.out.println("------------------------------------");
        System.out.println("Total de usuários: " + usuarios.size());
        System.out.println("Contas Free: " + qtdFree);
        System.out.println("Contas Premium: " + qtdPremium);
        // Exibe estatísticas baseadas em variáveis estáticas
        System.out.println("Total de reproduções no sistema: " + Usuario.totalReproducoesSistema);
        System.out.println("Total de anúncios exibidos (Free): " + UsuarioFree.totalAnunciosExibidos);
        System.out.println("------------------------------------");
    }

    private static void reproduzirAlgo() {
        if (usuarioLogado == null) return;
        
        try {
            System.out.println("\n--- BIBLIOTECA MUSICAL ---");
            for (int i = 0; i < bancoDeMusicas.size(); i++) {
                System.out.println(i + ". " + bancoDeMusicas.get(i).getTitulo() + " (" + bancoDeMusicas.get(i).getGenero() + ")");
            }
            
            System.out.print("Escolha o número da música: ");
            int mIdx = Integer.parseInt(scanner.nextLine());
            
            if (mIdx >= 0 && mIdx < bancoDeMusicas.size()) {
                Musica selecionada = bancoDeMusicas.get(mIdx);
                usuarioLogado.reproduzirMusica(selecionada);

                if (usuarioLogado instanceof UsuarioPremium) {
                    System.out.print("Deseja baixar para ouvir offline? (s/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        ((UsuarioPremium) usuarioLogado).baixarMusica(selecionada);
                    }
                }
            } else {
                System.out.println(" Música não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println(" Erro: Insira o número da música.");
        }
    }

    private static void gerenciarPlaylists() {
        if (usuarioLogado == null) return;

        try {
            System.out.println("\n1. Criar Playlist Personalizada");
            System.out.println("2. Gerar Playlist Automática (por Gênero)");
            System.out.println("3. Ouvir minhas Playlists");
            int subOpcao = Integer.parseInt(scanner.nextLine());

            if (subOpcao == 1 || subOpcao == 2) {
                System.out.print("Nome da playlist: ");
                String nome = scanner.nextLine();
                
                if (subOpcao == 2) {
                    System.out.print("Gênero desejado (Rock/Pop): ");
                    String crit = scanner.nextLine();
                    PlaylistAutomatica novaAuto = new PlaylistAutomatica(nome, crit);
                    novaAuto.atualizar(bancoDeMusicas);
                    usuarioLogado.adicionarPlaylist(novaAuto);
                } else {
                    System.out.print("Descrição da playlist: ");
                    String desc = scanner.nextLine();
                    usuarioLogado.adicionarPlaylist(new PlaylistPersonalizada(nome, desc));
                }
                System.out.println(" Playlist configurada!");

            } else if (subOpcao == 3) {
                if (usuarioLogado.getPlaylists().isEmpty()) {
                    System.out.println("ℹ️ Você ainda não possui playlists.");
                } else {
                    for (Playlist p : usuarioLogado.getPlaylists()) {
                        p.reproduzir(); // Chamada polimórfica de reproduzir()
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(" Erro: Opção inválida.");
        }
    }

    private static void criarUsuario() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Tipo (1. Free | 2. Premium): ");
            int tipo = Integer.parseInt(scanner.nextLine());

            if (tipo == 2) {
                System.out.print("Plano (Mensal/Anual): ");
                String plano = scanner.nextLine();
                usuarios.add(new UsuarioPremium(nome, email, plano));
            } else {
                usuarios.add(new UsuarioFree(nome, email));
            }
            System.out.println(" Usuário cadastrado!");
        } catch (NumberFormatException e) {
            System.out.println(" Erro ao criar: Use números para selecionar o tipo.");
        }
    }

    private static void realizarLogin() {
        if (usuarios.isEmpty()) {
            System.out.println(" Nenhum usuário no sistema.");
            return;
        }

        System.out.println("\n--- LOGIN ---");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + ". " + usuarios.get(i).getNome());
        }

        System.out.print("Selecione seu número: ");
        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            if (escolha >= 0 && escolha < usuarios.size()) {
                usuarioLogado = usuarios.get(escolha);
                System.out.println(" Login realizado como " + usuarioLogado.getNome());
            } else {
                System.out.println(" Usuário inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println(" Erro: Digite apenas o número do usuário.");
        }
    }

    private static void inicializarDados() {
        bancoDeMusicas.add(new Musica("Flowers", "Miley Cyrus", 200, "Pop"));
        bancoDeMusicas.add(new Musica("Equalize", "Pitty", 210, "Rock"));
        bancoDeMusicas.add(new Musica("In the End", "Linkin Park", 216, "Rock"));
    }
}
