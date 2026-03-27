import java.util.ArrayList;

public class Usuario {

    String nome;

    ArrayList<Playlist> playlist = new ArrayList<>();

    void criarPlaylist(String nome){
        Playlist nova = new Playlist();

        nova.nome = nome;

        this.playlists.add(nova):
          System.out.println("Playlist '" + nome + "criada com sucesso!");

    }
    
     Playlist gePlaylist( int indice){
        if (indice >= 0 && indice < playlists.size()){
            return
            playlist.get(indice);
        }
     }
}
