package br.com.streaming.util;

public class FormatadorTempo {
    public static String formatar(int segundos) {
        int min = segundos / 60;
        int seg = segundos % 60;
        return String.format("%d:%02d", min, seg);
    }
}
