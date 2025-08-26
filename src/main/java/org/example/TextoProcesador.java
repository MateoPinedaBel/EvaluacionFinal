package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class TextoProcesador {

    public static ArrayList<String> procesarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío.");
        }

        String textoLimpio = texto.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]", "").toLowerCase();
        String[] palabrasArray = textoLimpio.split("\\s+");
        return new ArrayList<>(Arrays.asList(palabrasArray));
    }

    public static int contarFrases(String texto) {
        if (texto == null || texto.trim().isEmpty()) return 0;
        String[] frases = texto.split("\\.");
        return (int) Arrays.stream(frases)
                .filter(f -> !f.trim().isEmpty())
                .count();
    }
}
