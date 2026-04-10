public class StreamingMusica {
    public static void main(String[] args) {

        Musica m1 = new Musica("Equalize", "Pitty", 320, "Rock");
        Musica m2 = new Musica("Billie Jean", "Michael Jackson", 294, "Pop");
        Musica m3 = new Musica("Mulher de Fases", "Raimundos", 230, "Rock");

        Playlist minhaPlaylist = new Playlist("Favoritas da Samara");

        minhaPlaylist.adicionarMusica(m1);
        minhaPlaylist.adicionarMusica(m2);
        minhaPlaylist.adicionarMusica(m3);

        Usuario usuario = new Usuario("Samara");
        usuario.adicionarPlaylist(minhaPlaylist);

        System.out.println("=== SISTEMA DE STREAMING ===");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Playlist: " + minhaPlaylist.getNome());
        System.out.println("----------------------------");

        for (Musica m : minhaPlaylist.getMusicas()) {
            m.exibir(); 
        }
    }
}