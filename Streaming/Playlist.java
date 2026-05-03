import java.util.ArrayList;

public class Playlist {

   
    protected String nome;
    protected ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }
    
    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
        System.out.println("Música " + musica.getTitulo() + " adicionada à playlist!");
    }
 
    public void removerMusica(int indice) {

        if (indice >= 0 && indice < this.musicas.size()) {
            this.musicas.remove(indice);
            System.out.println("Música removida com sucesso!");
        } else {
            System.out.println("Erro: Índice da música inválido!");
        }
    }

    public void reproduzir() {
        System.out.println("\n Reproduzindo playlist: " + this.nome);
        if (this.musicas.isEmpty()) {
            System.out.println("A playlist está vazia.");
        } else {
            for (Musica m : musicas) {
                System.out.println("   " + m.getTitulo() + " - " + m.getArtista());
            }
        }
    }

    public void listarMusicas() {
        System.out.println("\n=== Playlist: " + this.nome + " ===");
        if (this.musicas.isEmpty()) {
            System.out.println("Esta playlist ainda não tem músicas.");
        } else {
            for (int i = 0; i < this.musicas.size(); i++) {
                System.out.print(i + ". ");
                this.musicas.get(i).exibir();
            }
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : this.musicas) {
            total += m.getDuracaoSegundos();
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return this.musicas.size();
    }
}
