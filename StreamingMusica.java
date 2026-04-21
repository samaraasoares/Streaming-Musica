import java.util.Scanner;

public class StreamingMusica {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Musica m1 = new Musica("Equalize", "Pitty", 320, "Rock");
        Musica m2 = new Musica("Billie Jean", "Michael Jackson", 294, "Pop");
        Musica m3 = new Musica("Flowers", "Miley Cyrus", 200, "Pop");

        System.out.println("=== BEM-VINDO AO STREAMING ===");
        System.out.print("Digite seu nome: ");
        String nome = leitor.nextLine();
        
        System.out.print("Digite seu email: ");
        String email = leitor.nextLine();

        System.out.println("\nEscolha o tipo de conta:");
        System.out.println("1. Free (Com anúncios)");
        System.out.println("2. Premium (Alta qualidade)");
        System.out.print("Opção: ");
        int opcao = leitor.nextInt();

        Usuario usuarioLogado; 

        if (opcao == 2) {

          usuarioLogado = new UsuarioPremium(nome, email, "Mensal");
            System.out.println("Conta Premium criada com sucesso!");
        } else {

          usuarioLogado = new UsuarioFree(nome, email);
            System.out.println(" Conta Free criada com sucesso!");
        }

        System.out.println("\n--- TESTANDO REPRODUÇÃO ---");
        usuarioLogado.reproduzirMusica(m1);
        usuarioLogado.reproduzirMusica(m2);
        usuarioLogado.reproduzirMusica(m3); 

        leitor.close();
    }
}