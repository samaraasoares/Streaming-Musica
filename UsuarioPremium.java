import java.util.ArrayList;
import java.util.List;

public class UsuarioPremium extends Usuario {
    private String tipoPlano; 
    private List<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String tipoPlano) {
        super(nome, email);
        this.tipoPlano = tipoPlano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {

        System.out.println("💎 [ALTA QUALIDADE] Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void baixarMusica(Musica musica) {
        if (musica != null) {
            musicasBaixadas.add(musica);
            System.out.println("⬇️ Música '" + musica.getTitulo() + "' baixada com sucesso!");
        }
    }

    public void listarMusicasBaixadas() {
        System.out.println("\n--- MÚSICAS BAIXADAS (OFFLINE) ---");
        if (musicasBaixadas.isEmpty()) {
            System.out.println("Nenhuma música baixada.");
        } else {
            for (Musica m : musicasBaixadas) {
                System.out.println("- " + m.getTitulo());
            }
        }
    }

    public String getTipoPlano() { return tipoPlano; }
    public void setTipoPlano(String tipoPlano) { this.tipoPlano = tipoPlano; }
}