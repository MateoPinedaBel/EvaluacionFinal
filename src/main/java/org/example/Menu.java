package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Menu {

    private final Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n");
        System.out.println("===================================================");
        System.out.println("                  MENÚ PRINCIPAL                   ");
        System.out.println("===================================================");
        System.out.println("            1. Ingresar texto manualmente          ");
        System.out.println("            2. Usar texto predeterminado           ");
        System.out.println("            3. Leer texto desde archivo            ");
        System.out.println("                    4. Salir                       ");
        System.out.println("===================================================");
        System.out.print("  Seleccione una opción: ");
        String entrada = sc.nextLine().trim();
        System.out.println("===================================================");
        while (!entrada.matches("[1-4]")) {
            System.out.print("Entrada inválida. Ingrese 1, 2, 3 o 4: ");
            entrada = sc.nextLine().trim();
        }
        return Integer.parseInt(entrada);
    }

    public int mostrarSubmenuBusqueda() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("            MENÚ DE BÚSQUEDA               ");
        System.out.println("===========================================");
        System.out.println("    1. Ingrese la palabra que desea        ");
        System.out.println("       buscar.                             ");
        System.out.println("    2. Volver al Menú Principal            ");
        System.out.println("===========================================");
        System.out.print("  Seleccione una opción: ");
        String entrada = sc.nextLine().trim();
        System.out.println("===========================================");
        while (!entrada.matches("[1-2]")) {
            System.out.print("Entrada inválida. Ingrese 1 o 2: ");
            entrada = sc.nextLine().trim();
        }
        return Integer.parseInt(entrada);
    }

    public String pedirTexto() {
        System.out.println("Ingrese su texto completo: ");
        StringBuilder sb = new StringBuilder();
        String linea;
        while (!(linea = sc.nextLine()).isEmpty()) {
            sb.append(linea).append(" ");
        }
        return sb.toString().trim();
    }

    public String pedirPalabra() {
        System.out.print("Ingrese la palabra que desea buscar (solo letras): ");
        String entrada = sc.nextLine().trim().toLowerCase();

        if (entrada.isEmpty()) {
            throw new InputMismatchException("No ingresó ninguna palabra.");
        }

        String palabra = entrada.split("\\s+")[0];

        if (!palabra.matches("[a-zA-ZáéíóúñÁÉÍÓÚÑ]+")) {
            throw new InputMismatchException("La palabra ingresada contiene caracteres inválidos.");
        }

        return palabra;
    }

    public String leerTextoDesdeArchivo() {
        while (true) {
            System.out.print("Ingrese la ruta del archivo .txt ('0' para cancelar): ");
            String ruta = sc.nextLine().trim();

            if (ruta.equals("0")) {
                return "";
            }

            // Eliminar comillas
            if (ruta.startsWith("\"") && ruta.endsWith("\"")) {
                ruta = ruta.substring(1, ruta.length() - 1);
            }

            Path path = Paths.get(ruta);
            if (!Files.exists(path)) {
                System.out.println("El archivo no existe. Intente nuevamente.");
                continue;
            }

            try {
                return Files.readString(path);
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    public void cerrar() {
        sc.close();
    }
}
