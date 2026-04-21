public class UsuarioFree extends Usuario {
    private int contadorReproducoes;
    private static final int MAX_PLAYLISTS = 3;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
        this.contadorReproducoes = 0;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;
        
        if (contadorReproducoes % 3 == 0) {
            exibirAnuncio(); 
        }
        
        super.reproduzirMusica(musica); 
    }

    private void exibirAnuncio() {
        System.out.println("\n[ANÚNCIO] Assine o Premium para ouvir sem interrupções! \n");
    }

    @Override
    public void adicionarPlaylist(Playlist playlist) {
        if (playlists.size() >= MAX_PLAYLISTS) {
            System.out.println(" Limite de playlists atingido!");
        } else {
            super.adicionarPlaylist(playlist);
        }
    }
}