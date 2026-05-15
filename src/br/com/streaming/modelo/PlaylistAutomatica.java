package br.com.streaming.modelo;

import java.util.List;

public class PlaylistAutomatica extends Playlist {
    private String criterio;

    public PlaylistAutomatica(String titulo, String criterio) {
        super(titulo, "Playlist gerada automaticamente por gênero: " + criterio);
        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {
        System.out.println(" [ALGORITMO] Iniciando Mix de " + criterio);
        super.reproduzir();
    }

    public void atualizar(List<Musica> bancoDeMusicas) {
        this.musicas.clear(); 
        this.duracaoSegundos = 0; 

        for (Musica m : bancoDeMusicas) {
            if (m.getGenero().equalsIgnoreCase(this.criterio)) {
                this.adicionarMusica(m);
            }
        }
        System.out.println(" Atualizada: " + this.musicas.size() + " músicas encontradas.");
    }
}