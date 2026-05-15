package br.com.streaming.modelo;

public class Musica extends ItemReproducao {
    private String artista;
    private String genero;

    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        super(titulo);
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public void reproduzir() {
        System.out.println(" Tocando: " + titulo + " - " + artista);
    }

    @Override public void pausar() { System.out.println(" Pausado."); }
    @Override public void parar() { System.out.println("Parado."); }
}