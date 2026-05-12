package JuegoPalabra;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorPalabras gestorPalabras = new GestorPalabras();
        gestorPalabras.cargarPalabras("Palabras5L.txt");

        GestorPuntuaciones gestorPuntuaciones = new GestorPuntuaciones();
        Wordle wordle = new Wordle(gestorPalabras, gestorPuntuaciones);

        int opcion = -1;
        while (opcion != 4) {
            System.out.println("\n===== WORDLE =====");
            System.out.println("1. Nuevo juego");
            System.out.println("2. Cargar juego");
            System.out.println("3. Ver puntuaciones");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (opcion) {
                case 1 -> wordle.nuevoJuego();
                case 2 -> wordle.cargarJuego();
                case 3 -> gestorPuntuaciones.mostrarPuntuaciones();
                case 4 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

}
