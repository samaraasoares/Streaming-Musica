import java.util.ArrayList;

public class Playlist {
    protected String nome;
    protected String descricao; 
    protected ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }
 
    public void reproduzir() {
        System.out.println("\n Reproduzindo playlist: " + this.nome);
        System.out.println(" Descrição: " + this.descricao);
        if (this.musicas.isEmpty()) {
            System.out.println("   A playlist está vazia.");
        } else {
            for (Musica m : musicas) {
                System.out.println("    " + m.getTitulo() + " - " + m.getArtista());
            }
        }
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
}
