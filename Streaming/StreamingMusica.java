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
                System.out.println("Usuário: " + usuarioLogado.getNome() + " (" + 
                                   (usuarioLogado instanceof UsuarioPremium ? "Premium" : "Free") + ")");
                System.out.println("4. Ouvir Música");
                System.out.println("5. Criar Playlist");
                System.out.println("6. Logout");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> criarUsuario();
                case 2 -> realizarLogin();
                case 3 -> exibirEstatisticas();
                case 4 -> reproduzirAlgo();
                case 5 -> gerenciarPlaylists();
                case 6 -> usuarioLogado = null;
            }
        } while (opcao != 0);
    }

    private static void criarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.println("1. Free | 2. Premium");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 2) {
            System.out.print("Plano (Mensal/Anual): ");
            String plano = scanner.nextLine();
            usuarios.add(new UsuarioPremium(nome, email, plano));
        } else {
            usuarios.add(new UsuarioFree(nome, email));
        }
        System.out.println(" Usuário cadastrado!");
    }

    private static void realizarLogin() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("\n--- Selecione o Usuário ---");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + ". " + usuarios.get(i).getNome());
        }
        int escolha = Integer.parseInt(scanner.nextLine());
        usuarioLogado = usuarios.get(escolha);
        System.out.println(" Bem-vindo, " + usuarioLogado.getNome());
    }

    private static void exibirEstatisticas() {
        int qtdFree = 0, qtdPremium = 0;
        for (Usuario u : usuarios) {

            if (u instanceof UsuarioFree) qtdFree++;
            else if (u instanceof UsuarioPremium) qtdPremium++;
        }
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Total de Usuários: " + usuarios.size());
        System.out.println("- Free: " + qtdFree);
        System.out.println("- Premium: " + qtdPremium);
    }

    private static void reproduzirAlgo() {
        if (bancoDeMusicas.isEmpty()) return;
        Musica m = bancoDeMusicas.get(0);
        
        usuarioLogado.reproduzirMusica(m);
        
        if (usuarioLogado instanceof UsuarioPremium) {
            System.out.print("Deseja baixar esta música? (s/n): ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                ((UsuarioPremium) usuarioLogado).baixarMusica(m);
            }
        }
    }

    private static void gerenciarPlaylists() {
        System.out.println("1. Playlist Personalizada | 2. Playlist Automática");
        int tipo = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();

        Playlist nova;
        if (tipo == 2) {
            nova = new PlaylistAutomatica(nome, "Recomendadas");
        } else {
            nova = new PlaylistPersonalizada(nome);
        }

        usuarioLogado.adicionarPlaylist(nova);

        nova.reproduzir();
    }

    private static void inicializarDados() {
        bancoDeMusicas.add(new Musica("Musica A", "Artista X", 180, "Rock"));
        bancoDeMusicas.add(new Musica("Musica B", "Artista Y", 210, "Pop"));
    }
}
