import java.util.ArrayList;

public class Playlist {

    String nome;
    ArrayList<Musica> musicas = new ArrayList<>();

    
    void adicionarMusica(Musica musica)
{
     this.musicas.add(musica);
     System.out.println("Música " + musica.titulo + " adicionada á playlist!");
   }
 
    void removerMusica(int indice){

     if ( indice >= 0 && indice < this.musicas.size()) {

        this.musicas.remove(indice);
        System.out.println("Erro: Índice da musica inválido!");
     }
    }

    void listarMusicas(){
        System.out.println("\n=== Playlist: " + this.nome + "===");
     if (this.musicas.isEmpty()) {
            System.out.println("Está playlist ainda não tem músicas.");
            
        } else{
            for (int i = 0; i < this.musicas.size(); i++){
                System.out.println(i + ".");

            this.musicas.get(i).exibir();

            }
        }
    }

       int getDuracaoTotal(){
           int total = 0;

           for (Musica m : this.musicas){
                total += m.duracaoSegundos;
           }
           return total;
       }

       int getDuracaoMusicas(){
           return this.musicas.size();
       }

}
