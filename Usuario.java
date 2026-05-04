import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String nome;
    protected String email; 
    protected List<Playlist> playlists;
    protected List<Musica> historicoReproducao;

    public static int totalReproducoesSistema = 0; 

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
        this.historicoReproducao = new ArrayList<>();
    }

    public void reproduzirMusica(Musica musica) {
        System.out.println("Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);

        totalReproducoesSistema++; 
    }

    public final String getNome() { return nome; }
    public void adicionarPlaylist(Playlist playlist) {
        if (playlist != null) this.playlists.add(playlist);
    }
    public final List<Playlist> getPlaylists() { return playlists; }
}
