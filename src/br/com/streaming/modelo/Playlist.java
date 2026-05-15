package br.com.streaming.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Playlist extends ItemReproducao {
    protected String descricao;
    protected List<Musica> musicas = new ArrayList<>();

    public Playlist(String titulo, String descricao) {
        super(titulo);
        this.descricao = descricao;
    }

    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
        this.duracaoSegundos += musica.getDuracaoTotal();
    }

    @Override
    public void reproduzir() {
        System.out.println(" Playlist: " + titulo);
        for (Musica m : musicas) {
            m.reproduzir();
        }
    }

    @Override public void pausar() { System.out.println(" Playlist pausada."); }
    @Override public void parar() { System.out.println(" Playlist parada."); }
}