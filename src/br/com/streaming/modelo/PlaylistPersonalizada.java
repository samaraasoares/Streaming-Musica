package br.com.streaming.modelo;

public class PlaylistPersonalizada extends Playlist {
    
    public PlaylistPersonalizada(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public void reproduzir() {
        System.out.println(" [MINHA PLAYLIST]");
        super.reproduzir();
    }
}