import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio; 

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome, "Playlist gerada automaticamente por gênero: " + criterio);
        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {
        System.out.println(" [Playlist Automática via Algoritmo]");
        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> bancoDeMusicas) {
        this.musicas.clear();
        for (Musica m : bancoDeMusicas) {

            if (m.getGenero().equalsIgnoreCase(this.criterio)) {
                this.adicionarMusica(m);
            }
        }
        System.out.println("Atualizada: " + this.musicas.size() + " músicas de '" + criterio + "' encontradas.");
    }
}
