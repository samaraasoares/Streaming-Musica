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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo.trim();
        }
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        if (artista != null && !artista.trim().isEmpty()) {
            this.artista = artista.trim();
        }
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {

        if (duracaoSegundos > 0 && duracaoSegundos < 3600) {
            this.duracaoSegundos = duracaoSegundos;
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero != null) {
            String g = genero.trim();
            if (g.equalsIgnoreCase("Pop") || g.equalsIgnoreCase("Rock") || 
                g.equalsIgnoreCase("Jazz") || g.equalsIgnoreCase("Eletrônica") || 
                g.equalsIgnoreCase("Hip-Hop") || g.equalsIgnoreCase("Clássica")) {
                this.genero = g;
            } else {
                this.genero = "Desconhecido"; 
            }
        }
    }

    public void exibir() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Duração: " + getDuracaoFormatada());
        System.out.println("Gênero: " + this.genero);
        System.out.println("---------------------------");
    }

    public String getDuracaoFormatada() {
        int minutos = this.duracaoSegundos / 60;
        int segundos = this.duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public void reproduzir() {
    System.out.println("🎵 Reproduzindo playlist: " + nome);
    for (Musica m : musicas) {
        System.out.println("  ▶ " + m.getTitulo());
    }
}
}
