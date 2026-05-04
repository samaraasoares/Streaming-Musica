public class PlaylistPersonalizada extends Playlist {
    public PlaylistPersonalizada(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void reproduzir() {
        System.out.println(" [Playlist Personalizada]");
        super.reproduzir();
    }
}
