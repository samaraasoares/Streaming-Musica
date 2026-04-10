import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        setNome(nome);
        this.musicas = new ArrayList<>(); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public void adicionarMusica(Musica musica) {
        if (musica != null) {
            this.musicas.add(musica);
        } else {
            System.out.println("Erro: Não é possível adicionar uma música inexistente.");
        }
    }

    public void removerMusica(int indice) {

        if (indice >= 0 && indice < musicas.size()) {
            this.musicas.remove(indice);
        } else {
            System.out.println("Erro: Posição inválida na playlist.");
        }
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}