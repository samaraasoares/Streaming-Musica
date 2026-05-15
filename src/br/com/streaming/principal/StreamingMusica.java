package br.com.streaming.principal;

import br.com.streaming.modelo.*;
import br.com.streaming.servico.*;
import br.com.streaming.util.*;
import java.util.ArrayList;
import java.util.List;

public class StreamingMusica {
    public static void main(String[] args) {

        Musica m1 = new Musica("Bohemian Rhapsody", "Queen", 354, "Rock");
        Musica m2 = new Musica("Beat It", "Michael Jackson", 258, "Pop");
        Musica m3 = new Musica("Interstate Love Song", "STP", 194, "Rock");
        
        List<Musica> bancoGlobal = new ArrayList<>();
        bancoGlobal.add(m1);
        bancoGlobal.add(m2);
        bancoGlobal.add(m3);

        UsuarioPremium ana = new UsuarioPremium("Ana", "ana@email.com", "Familiar");
        UsuarioFree bruno = new UsuarioFree("Bruno", "bruno@email.com");

        System.out.println("=== SISTEMA DE STREAMING - VERSÃO 6.0 ===\n");

        System.out.println("--- Teste de Reprodução ---");
        ana.reproduzirMusica(m1); 
        
        bruno.reproduzirMusica(m2); 
        bruno.reproduzirMusica(m3);
        bruno.reproduzirMusica(m1); 

        System.out.println("\n--- Teste de Playlist Automática ---");
        PlaylistAutomatica mixRock = new PlaylistAutomatica("Mix Rock", "Rock");
        mixRock.atualizar(bancoGlobal);
        mixRock.reproduzir();

        System.out.println("\n--- Teste de Download ---");
        ana.baixar(m1);
        System.out.println("Downloads ativos de " + ana.getNome() + ": " + ana.getTamanhoBaixados());

        System.out.println("\n--- Serviços e Utilidades ---");
        GeradorRecomendacoes gerador = new GeradorRecomendacoes();
        gerador.recomendar(ana.getHistoricoReproducao());

        String tempoFormatado = FormatadorTempo.formatar(m1.getDuracaoTotal());
        System.out.println("Duração de '" + m1.getTitulo() + "': " + tempoFormatado);

        System.out.println("\n--- ESTATÍSTICAS DO SISTEMA ---");

        System.out.println("Total Global de Reproduções: " + Usuario.getTotalReproducoesSistema());
        System.out.println("Total de Anúncios Exibidos: " + UsuarioFree.totalAnunciosExibidos);
    }
}
