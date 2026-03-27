import java.util.ArrayList;
import java.util.Scanner;



public class StreamingMusica {



  static ArrayList<String> titulos = new ArrayList<>();

  static ArrayList<String> artistas = new ArrayList<>();

  static ArrayList<Integer> duracoes = new ArrayList<>();

  static ArrayList<String> generos = new ArrayList<>();



  static Scanner scanner = new Scanner(System.in);



  public static void main(String[] args) {

    adicionarMusicasTeste();



    int opcao;

    do {

      exibirMenu();

      opcao = lerOpcao();

      processarOpcao(opcao);

    } while (opcao != 0);



    System.out.println("\n🎵 Até logo! 🎵");

    scanner.close();

  }



  public static void exibirMenu() {

    System.out.println("\n=== SISTEMA DE STREAMING ===");

    System.out.println("1. Cadastrar música");

    System.out.println("2. Listar músicas");

    System.out.println("3. Buscar por título");

    System.out.println("0. Sair");

    System.out.print("Escolha: ");

  }



  public static int lerOpcao() {

    try {

      return Integer.parseInt(scanner.nextLine());

    } catch (NumberFormatException e) {

      return -1;

    }

  }



  public static void processarOpcao(int opcao) {

    switch (opcao) {

      case 1:

        cadastrarMusica();

        break;

      case 2:

        listarMusicas();

        break;

      case 3:

        buscarPorTitulo();

        break;

      case 0:

        System.out.println("Encerrando o Sistema...");

        break;

      default:

        System.out.println("Opção inválida! Tente novamente.");

        break;

    }

  }



  public static void cadastrarMusica() {

    System.out.println("\n--- CADASTRAR MÚSICA ---");



    System.out.print("Título da música: ");

    String titulo = scanner.nextLine();

    while (titulo.trim().isEmpty()) {

      System.out.print("O título não pode estar vazio. Digite novamente: ");

      titulo = scanner.nextLine();

    }



    System.out.print("Artista: ");

    String artista = scanner.nextLine();

    while (artista.trim().isEmpty()) {

      System.out.print("O artista não pode estar vazio. Digite novamente: ");

      artista = scanner.nextLine();

    }



    System.out.print("Duração (em segundos): ");

    String duracaoStr = scanner.nextLine();

    while (duracaoStr.trim().isEmpty()) {

      System.out.print("A duração é obrigatória. Digite novamente: ");

      duracaoStr = scanner.nextLine();

    }

    int duracaoSegundos = Integer.parseInt(duracaoStr);



    System.out.print("Gênero: ");

    String genero = scanner.nextLine();



    titulos.add(titulo);

    artistas.add(artista);

    duracoes.add(duracaoSegundos);

    generos.add(genero);



    System.out.println("\nMúsica '" + titulo + "' cadastrada com sucesso!");

  }



  public static void listarMusicas() {

    if (titulos.isEmpty()) {

      System.out.println("Nenhuma música cadastrada.");

      return;

    }



    for (int i = 0; i < titulos.size(); i++) {

      String titulo = titulos.get(i);

      String artista = artistas.get(i);

      int duracaoSegundos = duracoes.get(i);

      String tempoFormatado = formatarDuracao(duracaoSegundos);



      System.out.println((i + 1) + ". " + titulo + " - " + artista + " [" + tempoFormatado + "]");

    }

  }



  public static void buscarPorTitulo() {

    System.out.println("\n--- BUSCAR POR TÍTULO ---");

    System.out.print("Digite o título (ou parte dele): ");

    String busca = scanner.nextLine().toLowerCase();



    boolean encontrou = false;

    for (int i = 0; i < titulos.size(); i++) {

      String tituloAtual = titulos.get(i).toLowerCase();



      if (tituloAtual.contains(busca)) {

        String tempoFormatado = formatarDuracao(duracoes.get(i));

        System.out.println("Encontrada: " + titulos.get(i) + " - " + artistas.get(i) + " [" + tempoFormatado + "]");

        encontrou = true;

      }

    }



    if (!encontrou) {

      System.out.println("Nenhuma música encontrada com o termo: '" + busca + "'");

    }

  }



  public static String formatarDuracao(int segundos) {

    int min = segundos / 60;

    int seg = segundos % 60;

    return String.format("%d:%02d", min, seg);

  }



  public static void adicionarMusicasTeste() {

    titulos.add("Bohemian Rhapsody");

    artistas.add("Queen");

    duracoes.add(354);

    generos.add("Rock");



    titulos.add("Billie Jean");

    artistas.add("Michael Jackson");

    duracoes.add(293);

    generos.add("Pop");

  }

}