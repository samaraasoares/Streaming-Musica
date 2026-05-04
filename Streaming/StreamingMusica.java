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
            try {
                System.out.println("\n=== SISTEMA DE STREAMING (CP5 - FINAL) ===");
                if (usuarioLogado == null) {
                    System.out.println("1. Criar novo usuário | 2. Login | 3. Estatísticas | 0. Sair");
                } else {
                    String tipo = (usuarioLogado instanceof UsuarioPremium) ? "Premium" : "Free";
                    System.out.println(" " + usuarioLogado.getNome() + " [" + tipo + "]");
                    System.out.println("4. Ouvir Música | 5. Gerenciar Playlists | 6. Logout | 0. Sair");
                }
                System.out.print("Escolha: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> criarUsuario();
                    case 2 -> realizarLogin();
                    case 3 -> exibirEstatisticas();
                    case 4 -> reproduzirAlgo();
                    case 5 -> gerenciarPlaylists();
                    case 6 -> { usuarioLogado = null; System.out.println("Logout ok."); }
                    case 0 -> System.out.println("Encerrando...");
                }
            } catch (Exception e) {
                System.out.println(" Erro: Entrada inválida. Use apenas números.");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void exibirEstatisticas() {
        int free = 0, premium = 0;
        for (Usuario u : usuarios) {
            if (u instanceof UsuarioFree) free++; else premium++;
        }
        System.out.println("\n--- ESTATÍSTICAS DETALHADAS ---");
        System.out.println(" Usuários: " + usuarios.size() + " (Free: " + free + " | Premium: " + premium + ")");
        System.out.println(" Total de Reproduções: " + Usuario.totalReproducoesSistema);
        System.out.println(" Anúncios Exibidos: " + UsuarioFree.totalAnunciosExibidos);
    }

    private static void reproduzirAlgo() {
        if (usuarioLogado == null) return;
        try {
            System.out.println("\n--- MÚSICAS ---");
            for (int i = 0; i < bancoDeMusicas.size(); i++) 
                System.out.println(i + ". " + bancoDeMusicas.get(i).getTitulo());
            
            System.out.print("Escolha o número: ");
            int mIdx = Integer.parseInt(scanner.nextLine());
            
            if (mIdx >= 0 && mIdx < bancoDeMusicas.size()) {
                Musica m = bancoDeMusicas.get(mIdx);
                usuarioLogado.reproduzirMusica(m);
                if (usuarioLogado instanceof UsuarioPremium) {
                    System.out.print("Baixar? (s/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("s")) 
                        ((UsuarioPremium) usuarioLogado).baixarMusica(m);
                }
            }
        } catch (Exception e) { System.out.println(" Seleção inválida."); }
    }

    private static void gerenciarPlaylists() {
        if (usuarioLogado == null) return;
        try {
            System.out.println("\n1. Nova Personalizada | 2. Nova Automática | 3. Ouvir Minhas");
            int op = Integer.parseInt(scanner.nextLine());
            
            if (op == 1 || op == 2) {
                System.out.print("Nome: "); String nome = scanner.nextLine();
                if (op == 1) {
                    System.out.print("Descrição: "); String desc = scanner.nextLine();
                    usuarioLogado.adicionarPlaylist(new PlaylistPersonalizada(nome, desc));
                } else {
                    System.out.print("Gênero (Rock/Pop): "); String gen = scanner.nextLine();
                    PlaylistAutomatica auto = new PlaylistAutomatica(nome, gen);
                    auto.atualizar(bancoDeMusicas);
                    usuarioLogado.adicionarPlaylist(auto);
                }
                System.out.println("Playlist criada!");
            } else {
                for (Playlist p : usuarioLogado.getPlaylists()) p.reproduzir();
            }
        } catch (Exception e) { System.out.println(" Erro na operação."); }
    }

    private static void criarUsuario() {
        System.out.print("Nome: "); String n = scanner.nextLine();
        System.out.print("Email: "); String e = scanner.nextLine();
        System.out.print("1. Free | 2. Premium: ");
        int t = Integer.parseInt(scanner.nextLine());
        if (t == 2) {
            System.out.print("Plano: "); String p = scanner.nextLine();
            usuarios.add(new UsuarioPremium(n, e, p));
        } else usuarios.add(new UsuarioFree(n, e));
        System.out.println(" Cadastrado!");
    }

    private static void realizarLogin() {
        if (usuarios.isEmpty()) return;
        for (int i = 0; i < usuarios.size(); i++) System.out.println(i + ". " + usuarios.get(i).getNome());
        System.out.print("Número: ");
        int idx = Integer.parseInt(scanner.nextLine());
        usuarioLogado = usuarios.get(idx);
        System.out.println(" Bem-vindo " + usuarioLogado.getNome());
    }

    private static void inicializarDados() {
        bancoDeMusicas.add(new Musica("Flowers", "Miley Cyrus", 200, "Pop"));
        bancoDeMusicas.add(new Musica("Equalize", "Pitty", 210, "Rock"));
        bancoDeMusicas.add(new Musica("In the End", "Linkin Park", 216, "Rock"));
    }
}
