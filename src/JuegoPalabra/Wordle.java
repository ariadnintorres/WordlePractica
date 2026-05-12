package JuegoPalabra;
import java.util.Scanner;

public class Wordle {

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		      
		        String palabraSecreta = "PUNTO"; 
		        int intentos = 6;
		        boolean adivinada = false;

		        System.out.println("¡Bienvenido a Wordle!");
		        System.out.println("Adivina la palabra oculta de 5 letras.");
		        System.out.println("Guía:");
		        System.out.println(" [+] Letra correcta en la posición correcta.");
		        System.out.println(" [*] Letra correcta en la posición INCORRECTA.");
		        System.out.println(" [-] Letra incorrecta.");
		        System.out.println("------------------------------------------------");

		        for (int i = 0; i < intentos; i++) {
		            System.out.print("\nIntento " + (i + 1) + " de " + intentos + ". Escribe una palabra: ");
		            String intentoUsuario = scanner.nextLine().toUpperCase();

		         
		            if (intentoUsuario.length() != 5) {
		                System.out.println("¡Error! La palabra debe tener exactamente 5 letras. Pierdes un intento.");
		                continue; 

		            if (intentoUsuario.equals(palabraSecreta)) {
		                System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
		                adivinada = true;
		                break;
		            }  
	}

}
}
