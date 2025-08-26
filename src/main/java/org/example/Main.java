package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        String textoPredeterminado = """
                Cuando yo tenía seis años vi en un libro una magnífica lámina.
                Representaba una serpiente boa que se tragaba a una fiera.
                En el libro se decía: "Las boas tragan a sus presas enteras, sin masticarlas.
                Después ya no pueden moverse y duermen durante los seis meses de su digestión".
                Reflexioné mucho entonces sobre las aventuras de la selva y, a mi vez, logré
                trazar con un lápiz de colores mi primer dibujo.
                Era una obra maestra que representaba una serpiente boa digiriendo un elefante.
                Mostré mi obra a las personas mayores y les pregunté si mi dibujo les asustaba.
                Me respondieron: "¿Por qué habría de asustar un sombrero?".
                Mi dibujo no representaba un sombrero.
                Representaba una serpiente boa que digiere un elefante.
                Es necesario explicar a los adultos muchas cosas, porque nunca comprenden nada por sí mismos.
                """;

        try {
            boolean salir = false;

            while (!salir) {
                int opcion = menu.mostrarMenuPrincipal();
                String texto = "";

                switch (opcion) {
                    case 1 -> texto = menu.pedirTexto();
                    case 2 -> texto = textoPredeterminado;
                    case 3 -> texto = menu.leerTextoDesdeArchivo();
                    case 4 -> {
                        salir = true;
                        continue;
                    }
                    default -> {
                        System.out.println("Opción inválida, intente de nuevo.");
                        continue;
                    }
                }

                // Validar texto
                if (texto == null || texto.isEmpty()) {
                    System.out.println("No se obtuvo texto. Volviendo al menú principal...");
                    continue;
                }

                ArrayList<String> palabras = TextoProcesador.procesarTexto(texto);
                HashMap<String, Integer> mapa = EstadisticasTexto.mapearFrecuencias(palabras);

                // Mostrar el Texto

                if (opcion != 1)
                    System.out.println("\n"+ texto);

                // Estadísticas
                System.out.println("\n--- Estadísticas del Texto ---");
                System.out.println("Cantidad de palabras distintas: " + mapa.size());
                System.out.printf("Longitud promedio de palabras: %.2f\n", EstadisticasTexto.longitudPromedio(palabras));
                System.out.println("Cantidad de frases: " + TextoProcesador.contarFrases(texto));

                String palabraTop = EstadisticasTexto.palabraMasFrecuente(mapa);
                int cantidadTop = EstadisticasTexto.cantidadPalabraMasFrecuente(mapa);
                double porcentajeTop = EstadisticasTexto.porcentajePalabraMasFrecuente(mapa);
                System.out.print("\n");
                System.out.println("                ============================");
                System.out.println("                   Listado de Palabras     ");
                System.out.println("                ============================");
                System.out.print("\n");
                EstadisticasTexto.mostrarTodas(mapa,3);
                System.out.println("\nPalabra más frecuente: '" + palabraTop + "' aparece "
                        + cantidadTop + " veces (" + String.format("%.2f", porcentajeTop) + "% del total).");

                EstadisticasTexto.mostrarTop(mapa, 5);

                // Submenú de búsqueda
                boolean volverBusquedas = false;
                while (!volverBusquedas) {
                    int opcionBusqueda = menu.mostrarSubmenuBusqueda();
                    switch (opcionBusqueda) {
                        case 1 -> {
                            try {
                                String palabraBuscada = menu.pedirPalabra();
                                int conteo = EstadisticasTexto.contarPalabra(mapa, palabraBuscada);
                                System.out.println("La palabra '" + palabraBuscada + "' aparece " + conteo + " veces.");
                            } catch (InputMismatchException e) {
                                System.out.println("Error en la entrada: " + e.getMessage());
                            }
                        }
                        case 2 -> volverBusquedas = true;
                        default -> System.out.println("Opción inválida. Intente de nuevo.");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: lista o mapa nulo.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            menu.cerrar();
        }
    }
}
