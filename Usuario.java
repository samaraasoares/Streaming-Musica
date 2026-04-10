import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private List<Playlist> playlists;

    public Usuario(String nome) {
        setNome(nome);
        this.playlists = new ArrayList<>(); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (playlist != null) {
            this.playlists.add(playlist);
        }
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}