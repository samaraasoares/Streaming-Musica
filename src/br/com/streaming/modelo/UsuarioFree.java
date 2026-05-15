package br.com.streaming.modelo;

public class UsuarioFree extends Usuario {
    private int contadorReproducoes = 0;
    public static int totalAnunciosExibidos = 0; 

    public UsuarioFree(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;
        if (contadorReproducoes % 3 == 0) {
            System.out.println("\n [ANÚNCIO] Assine o Premium!\n");
            totalAnunciosExibidos++;
        }
        System.out.println(" Reproduzindo: " + musica.getTitulo());
        this.historicoReproducao.add(musica);
        this.registrarReproducao(); 
    }
}