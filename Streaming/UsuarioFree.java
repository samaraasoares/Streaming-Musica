public class UsuarioFree extends Usuario {
    private int contadorReproducoesLocal;
    public static int totalAnunciosExibidos = 0; 
    private static final int MAX_PLAYLISTS = 3;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
        this.contadorReproducoesLocal = 0;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoesLocal++;
        if (contadorReproducoesLocal % 3 == 0) {
            exibirAnuncio(); 
        }
        super.reproduzirMusica(musica); 
    }

    private void exibirAnuncio() {
        System.out.println("\n [ANÚNCIO] Assine o Premium para ouvir sem interrupções!");
        totalAnunciosExibidos++;
    }

    @Override
    public void adicionarPlaylist(Playlist playlist) {
        if (playlists.size() >= MAX_PLAYLISTS) {
            System.out.println(" Limite de 3 playlists atingido para conta Free!");
        } else {
            super.adicionarPlaylist(playlist);
        }
    }
}
