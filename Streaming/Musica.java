public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { if (titulo != null) this.titulo = titulo.trim(); }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { if (artista != null) this.artista = artista.trim(); }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public void setDuracaoSegundos(int duracaoSegundos) { if (duracaoSegundos > 0) this.duracaoSegundos = duracaoSegundos; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public void exibir() {
        System.out.println(" " + titulo + " - " + artista + " [" + getDuracaoFormatada() + "] (" + genero + ")");
    }

    public String getDuracaoFormatada() {
        return (duracaoSegundos / 60) + ":" + String.format("%02d", (duracaoSegundos % 60));
    }
}
