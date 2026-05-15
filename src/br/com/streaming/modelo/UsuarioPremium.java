package br.com.streaming.modelo;

import br.com.streaming.servico.Baixavel;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPremium extends Usuario implements Baixavel {
    private String tipoPlano; 
    private List<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String tipoPlano) {
        super(nome, email);
        this.tipoPlano = tipoPlano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void baixar(Musica musica) {
        if (!estaBaixada(musica)) {
            musicasBaixadas.add(musica);
            System.out.println(" Baixada: " + musica.getTitulo());
        }
    }

    @Override public void removerDownload(Musica musica) { musicasBaixadas.remove(musica); }
    @Override public boolean estaBaixada(Musica musica) { return musicasBaixadas.contains(musica); }
    @Override public int getTamanhoBaixados() { return musicasBaixadas.size(); }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.println(" [ALTA QUALIDADE] " + musica.getTitulo());
        this.historicoReproducao.add(musica); 
        this.registrarReproducao(); 
    }
}