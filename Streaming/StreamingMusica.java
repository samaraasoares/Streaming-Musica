import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Musica> bancoDeMusicas = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING (CP5) ===");
            
            if (usuarioLogado == null) {
                System.out.println("1. Criar novo usuário");
                System.out.println("2. Login");
                System.out.println("3. Ver Estatísticas do Sistema");
            } else {

                String tipo = (usuarioLogado instanceof UsuarioPremium) ? "Premium" : "Free";
                System.out.println(" Usuário: " + usuarioLogado.getNome() + " [" + tipo + "]");
                System.out.println("4. Ouvir Música (Simulação)");
                System.out.println("5. Gerenciar Playlists (Nova/Ouvir)");
                System.out.println("6. Logout");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; // Força cair no default do switch
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
                default -> System.out.println("  Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void criarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.println("Tipo de conta: 1. Free | 2. Premium");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 2) {
            System.out.print("Plano (Mensal/Anual): ");
            String plano = scanner.nextLine();
            usuarios.add(new UsuarioPremium(nome, email, plano));
        } else {
            usuarios.add(new UsuarioFree(nome, email));
        }
        System.out.println(" Usuário cadastrado com sucesso!");
    }

    private static void realizarLogin() {
        if (usuarios.isEmpty()) {
            System.out.println("  Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n--- SELECIONE O USUÁRIO ---");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + ". " + usuarios.get(i).getNome());
        }

        System.out.print("Digite o número do usuário: ");
        try {
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha >= 0 && escolha < usuarios.size()) {
                usuarioLogado = usuarios.get(escolha);
                System.out.println("  Bem-vindo, " + usuarioLogado.getNome() + "!");
            } else {
                System.out.println("  Opção inválida! O usuário selecionado não existe.");
            }

            
        } catch (NumberFormatException e) {
            System.out.println("  Erro: Por favor, digite apenas números.");
        }
    }

    private static void exibirEstatisticas() {
        int qtdFree = 0, qtdPremium = 0;
        System.out.println("\n=== ESTATÍSTICAS DO SISTEMA ===");
        
        for (Usuario u : usuarios) {

            if (u instanceof UsuarioFree) {
                qtdFree++;
            } else if (u instanceof UsuarioPremium) {
                qtdPremium++;

                UsuarioPremium up = (UsuarioPremium) u;
                System.out.println("-> Premium: " + up.getNome() + " (Plano " + up.getTipoPlano() + ")");
            }
        }
        System.out.println("Total de usuários: " + usuarios.size());
        System.out.println("Contas Free: " + qtdFree);
        System.out.println("Contas Premium: " + qtdPremium);
    }

    private static void reproduzirAlgo() {
        if (usuarioLogado == null) return;
        
        System.out.println("\n--- MÚSICAS DISPONÍVEIS ---");
        for (int i = 0; i < bancoDeMusicas.size(); i++) {
            System.out.println(i + ". " + bancoDeMusicas.get(i).getTitulo());
        }
        
        System.out.print("Escolha a música: ");
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
        }
    }

    private static void gerenciarPlaylists() {
        System.out.println("\n1. Criar Playlist Personalizada");
        System.out.println("2. Gerar Playlist Automática");
        System.out.println("3. Ouvir minhas Playlists");
        int subOpcao = Integer.parseInt(scanner.nextLine());

        if (subOpcao == 1 || subOpcao == 2) {
            System.out.print("Nome da playlist: ");
            String nome = scanner.nextLine();
            Playlist nova;

            if (subOpcao == 2) {
                System.out.print("Critério (Top/Recentes/Relax): ");
                String crit = scanner.nextLine();
                nova = new PlaylistAutomatica(nome, crit);

                ((PlaylistAutomatica) nova).atualizar(bancoDeMusicas);
            } else {
                nova = new PlaylistPersonalizada(nome);
                if (!bancoDeMusicas.isEmpty()) nova.adicionarMusica(bancoDeMusicas.get(0));
            }

            usuarioLogado.adicionarPlaylist(nova);
            System.out.println("  Playlist criada!");

        } else if (subOpcao == 3) {
            if (usuarioLogado.getPlaylists().isEmpty()) {
                System.out.println(" Você não tem playlists.");
            } else {
                for (Playlist p : usuarioLogado.getPlaylists()) {
                    p.reproduzir();
                }
            }
        }
    }

    private static void inicializarDados() {
        bancoDeMusicas.add(new Musica("Flowers", "Miley Cyrus", 200, "Pop"));
        bancoDeMusicas.add(new Musica("Equalize", "Pitty", 210, "Rock"));
        bancoDeMusicas.add(new Musica("In the End", "Linkin Park", 216, "Rock"));
    }
}
