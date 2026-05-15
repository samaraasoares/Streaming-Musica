
package br.com.streaming.modelo;

import br.com.streaming.servico.Reproduzivel;

public abstract class ItemReproducao implements Reproduzivel {
    protected String titulo;
    protected int duracaoSegundos;

    public ItemReproducao(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() { return titulo; }
    @Override public int getDuracaoTotal() { return duracaoSegundos; }
}
