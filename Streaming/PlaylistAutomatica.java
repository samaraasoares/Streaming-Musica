import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio; 

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {
        System.out.println(" [Playlist Automática via Algoritmo]");
        System.out.println(" Critério de seleção: " + this.criterio);
        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        this.musicas.clear();
        System.out.println(" Atualizando playlist '" + this.nome + "' baseada em: " + criterio);
        
        if (todasMusicas.size() >= 2) {
            this.adicionarMusica(todasMusicas.get(0));
            this.adicionarMusica(todasMusicas.get(1));
        }
    }

    public String getCriterio() {
        return criterio;
    }
}
