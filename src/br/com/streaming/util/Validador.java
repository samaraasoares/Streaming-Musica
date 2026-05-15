package br.com.streaming.util;

public class Validador {

    
    public static boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    
    public static boolean campoNaoVazio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
}