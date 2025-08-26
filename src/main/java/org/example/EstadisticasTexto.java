package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EstadisticasTexto {

    public static HashMap<String, Integer> mapearFrecuencias(ArrayList<String> palabras) {
        if (palabras == null) throw new NullPointerException("La lista de palabras es nula.");
        return palabras.stream()
                .collect(Collectors.toMap(
                        p -> p,
                        p -> 1,
                        Integer::sum,
                        HashMap::new
                ));
    }

    public static void mostrarTodas(HashMap<String, Integer> mapa, int columnas) {
        if (mapa == null || mapa.isEmpty()) {
            System.out.println("No hay palabras para mostrar.");
            return;
        }

        var listaOrdenada = mapa.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .toList();

        int contador = 0;
        for (var e : listaOrdenada) {
            System.out.printf("%-15s: %-5d\t", e.getKey(), e.getValue());
            contador++;
            if (contador % columnas == 0) {
                System.out.println();
            }
        }
        if (contador % columnas != 0) System.out.println();
    }

    public static void mostrarTop(HashMap<String, Integer> mapa, int n) {
        if (mapa == null) throw new NullPointerException("El mapa es nulo.");
        System.out.println("\n--- Palabras más frecuentes ---");
        mapa.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(n)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public static double longitudPromedio(ArrayList<String> palabras) {
        if (palabras == null || palabras.isEmpty()) return 0;
        return palabras.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    public static int contarPalabra(HashMap<String, Integer> mapa, String palabra) {
        if (mapa == null) throw new NullPointerException("El mapa es nulo.");
        return mapa.getOrDefault(palabra.toLowerCase(), 0);
    }

    public static String palabraMasFrecuente(HashMap<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) return "";
        return mapa.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static int cantidadPalabraMasFrecuente(HashMap<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) return 0;
        return mapa.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static double porcentajePalabraMasFrecuente(HashMap<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) return 0;
        int total = mapa.values().stream().mapToInt(Integer::intValue).sum();
        int max = mapa.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        return ((double) max / total) * 100;
    }
}
