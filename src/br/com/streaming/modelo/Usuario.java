package br.com.streaming.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String nome;
    protected String email; 
    protected List<Playlist> playlists = new ArrayList<>();
    protected List<Musica> historicoReproducao = new ArrayList<>();
    protected int reproducoesIndividuais = 0; 
    
    private static int totalReproducoesSistema = 0; 

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public abstract void reproduzirMusica(Musica musica);

    protected void registrarReproducao() {
        this.reproducoesIndividuais++;
        totalReproducoesSistema++;
    }

    public static int getTotalReproducoesSistema() {
        return totalReproducoesSistema;
    }

    public String getNome() { return nome; }
    public List<Musica> getHistoricoReproducao() { return historicoReproducao; }
    public void adicionarPlaylist(Playlist p) { this.playlists.add(p); }
}