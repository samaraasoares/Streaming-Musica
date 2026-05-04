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
        System.out.println(" [ALTA QUALIDADE] Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);
        totalReproducoesSistema++;
    }

    public void baixarMusica(Musica musica) {
        musicasBaixadas.add(musica);
        System.out.println(" Música '" + musica.getTitulo() + "' baixada!");
    }

    public String getTipoPlano() { return tipoPlano; }
}
