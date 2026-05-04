import java.util.ArrayList;

public class Playlist {
    protected String nome;
    protected String descricao; // NOVO CAMPO
    protected ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome, String descricao) { 
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }
 
    public void reproduzir() {
        System.out.println("\n Playlist: " + this.nome + " (" + this.descricao + ")");
        if (this.musicas.isEmpty()) {
            System.out.println("Vazia.");
        } else {
            for (Musica m : musicas) {
                System.out.println("   " + m.getTitulo());
            }
        }
    }

    public String getNome() { return nome; }
}
