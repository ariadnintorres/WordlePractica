package JuegoPalabra;
import java.util.*;
public class Partida {

	//Gestor de Palabra
	//Gestor de Puntuaciones hashMap 
	//menu principal
	//fichero de palabras
	
	private String palabraSecreta;
	private int intentosRestantes;
	
	String contenido = lector.nextLine();
	String [] partes = contenido.split(",");
	for ()
 	
	
	 private String generarPalabraSecreta() {
	        Random random = new Random();
	        int indice = random.nextInt(bancoPalabras.length);
	        return bancoPalabras[indice];
	    }
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
    
    // Array de palabras dentro de la misma clase
  
    // Constructor: Al crear una nueva partida, se configura todo automáticamente
    public Partida() {
        this.palabraSecreta = generarPalabraSecreta();
        this.intentosRestantes = 6;
    }

    // El método que querías para elegir la palabra
    private String generarPalabraSecreta() {
        Random random = new Random();
        int indice = random.nextInt(bancoPalabras.length);
        return bancoPalabras[indice];
    }

    // Métodos para que la clase principal pueda consultar el estado
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public void restarIntento() {
        intentosRestantes--;
    }
}
2. Tu clase Wordle (La principal)
Y aquí tienes cómo la clase Wordle utiliza a la clase Partida para hacer funcionar el juego.

Java
package logica; // Usa el nombre de tu paquete

import java.util.Scanner;

public class Wordle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creamos una nueva partida (esto elige la palabra sola gracias al constructor)
        Partida partidaActual = new Partida();
        boolean adivinada = false;

        System.out.println("¡Bienvenido a Wordle!");
        System.out.println("Adivina la palabra de 5 letras. Tienes " + partidaActual.getIntentosRestantes() + " intentos.");

        // Bucle que dura mientras queden intentos y no se haya adivinado
        while (partidaActual.getIntentosRestantes() > 0 && !adivinada) {
            System.out.print("\nEscribe tu palabra (Intento " + (7 - partidaActual.getIntentosRestantes()) + "/6): ");
            String intentoUsuario = scanner.nextLine().toUpperCase();

            if (intentoUsuario.length() != 5) {
                System.out.println("¡La palabra debe tener 5 letras!");
                continue;
            }

            if (intentoUsuario.equals(partidaActual.getPalabraSecreta())) {
                System.out.println("\n¡Felicidades! Adivinaste la palabra.");
                adivinada = true;
            } else {
                // Aquí iría la lógica visual de los [+], [*] y [-] que vimos antes
                System.out.println("Palabra incorrecta.");
                partidaActual.restarIntento();
            }
        }

        if (!adivinada) {
            System.out.println("\nFin del juego. La palabra secreta era: " + partidaActual.getPalabraSecreta());
        }
        
        scanner.close();
    }*/
	
}
