import java.util.ArrayList;
import java.util.List;

public class Usuario {

    protected String nome;
    protected String email; 
    protected List<Playlist> playlists;
    protected List<Musica> historicoReproducao;

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
        this.playlists = new ArrayList<>();
        this.historicoReproducao = new ArrayList<>();
    }

    public void reproduzirMusica(Musica musica) {
        System.out.println("Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void exibirHistorico() {
        System.out.println("\n--- HISTÓRICO DE REPRODUÇÃO ---");
        for (Musica m : historicoReproducao) {
            m.exibir();
        }
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { if (nome != null) this.nome = nome.trim(); }

    public String getEmail() { return email; }
    public void setEmail(String email) { if (email != null) this.email = email.trim(); }

    public void adicionarPlaylist(Playlist playlist) {
        if (playlist != null) this.playlists.add(playlist);
    }

    public List<Playlist> getPlaylists() { return playlists; }
}
