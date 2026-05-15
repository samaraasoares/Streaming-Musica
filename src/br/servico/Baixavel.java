package br.com.streaming.servico;

import br.com.streaming.modelo.Musica;

public interface Baixavel {
    void baixar(Musica musica);
    void removerDownload(Musica musica);
    boolean estaBaixada(Musica musica);
    int getTamanhoBaixados();
}
package br.com.streaming.servico;

import br.com.streaming.modelo.Musica;
import java.util.List;

public class GeradorRecomendacoes {
    
    public void recomendar(List<Musica> historico) {
        System.out.println("--- Sugestões de Música ---");
        
        if (historico.isEmpty()) {
            System.out.println("Ouça algo para receber recomendações personalizadas.");
        } else {

            Musica recomendada = historico.get(0); 
            System.out.println("Com base no seu gosto, recomendamos mais de: " + recomendada.getArtista());
        }
    }
}
package br.com.streaming.servico;

public interface Reproduzivel {
    void reproduzir();
    void pausar();
    void parar();
    int getDuracaoTotal();
}
