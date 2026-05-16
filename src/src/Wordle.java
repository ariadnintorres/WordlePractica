//package src;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
///**
// * Clase principal que gestiona la lógica del juego Wordle.
// * Controla los turnos, vidas, retroalimentación y el guardado en fichero binario.
// *
// * @author ariad
// */
//
//public class Wordle {
//	
//	
//	
//	private static final int MAX_VIDAS        = 6;
//	private static final int LONGITUD_PALABRA = 5;
//	private static final String FICHERO_ESTADO = "estado_juego.dat";
//
//
//	private static final String RESET    = "\033[0m";
//	private static final String VERDE    = "\033[42m\033[30m";
//	private static final String AMARILLO = "\033[43m\033[30m";
//	private static final String GRIS     = "\033[100m\033[97m";
//
//
//	private String palabraOculta;
//	private int vidasRestantes;
//	private ArrayList<String> intentos;
//	private int puntuacionAcumulada;
//	private HashMap<Character, String> estadoLetras;
//    private GestorPalabras gestorPalabras;
//	private Scanner scanner;
//
//	/**
//	 * Constructor para nuevo juego. Elige palabra aleatoria y resetea vidas.
//	 *
//	 * @param gestorPalabras Gestor con la lista de palabras cargadas
//	 * @param scanner        Scanner para leer la entrada del usuario
//	 */
//	public Wordle(/*GestorPalabras gestorPalabras*/ Scanner scanner) {
//		// this.gestorPalabras      = gestorPalabras;
//		this.scanner             = scanner;
//		this.intentos            = new ArrayList<>();
//		this.puntuacionAcumulada = 0;
//		 iniciarNuevaRonda();
//	}
//
//	/**
//	 * Constructor para cargar una partida guardada desde fichero binario.
//	 *
//	 * @param gestorPalabras Gestor de palabras
//	 * @param scanner        Scanner de entrada
//	 * @param estado         Estado cargado del fichero .dat
//	 */
//	public Wordle(/*GestorPalabras gestorPalabras*/ Scanner scanner, EstadoJuego estado) {
//		//this.gestorPalabras      = gestorPalabras;
//		this.scanner             = scanner;
//		this.palabraOculta       = estado.getPalabraOculta();
//		this.vidasRestantes      = estado.getVidasRestantes();
//		this.intentos            = estado.getIntentos();
//		this.puntuacionAcumulada = estado.getPuntuacionAcumulada();
//		this.estadoLetras        = estado.getEstadoLetras();
//	}
//
//	/**
//	 * Selecciona una nueva palabra aleatoria y reinicia las vidas e intentos.
//	 */
//	private void iniciarNuevaRonda() {
//		//palabraOculta  = gestorPalabras.getPalabraAleatoria();
//	    vidasRestantes = MAX_VIDAS;
//	    intentos       = new ArrayList<>();
//	    estadoLetras   = new HashMap<>();
//	} 
//	
//	
//	public ArrayList<String> procesarIntento(String intento){
//
//		intentos.add(intento).toUpperCase();
//		ArrayList<String> resultado = evaluar(intento.toUpperCase());
//		if (!esPalabraCorrecta(resultado)) {
//			vidasRestantes--;
//		}
//		return resultado;
//	}
//
//	
//	private ArrayList<String> evaluar (String intento){
//		
//		ArrayList<String> resultado = new ArrayList<String>();
//		ArrayList<String> secreta = new ArrayList<String>();
//		ArrayList<String> intentoArray = new ArrayList<String>();
//	   
//		for (int i =0; i < LONGITUD_PALABRA;i++) {
//			secreta.add(palabraOculta.charAt(i));
//			intentoArray.add(intento.charAt(i));
//			resultado.add(null);
//			
//		}
//		
//		 for (int i = 0; i < LONGITUD_PALABRA; i++) {
//	            if (intentoArray.get(i).equals(secreta.get(i))) {
//	                resultado.set(i, "correct");
//	                secreta.set(i, '*');
//	                intentoArray.set(i, '#');
//	            }
//	        }
//
//	        // Segunda pasada: amarillos y grises
//	        for (int i = 0; i < LONGITUD_PALABRA; i++) {
//	            if (resultado.get(i) != null) continue;
//	            boolean encontrada = false;
//	            for (int j = 0; j < LONGITUD_PALABRA; j++) {
//	                if (intentoArray.get(i).equals(secreta.get(j))) {
//	                    resultado.set(i, "present");
//	                    secreta.set(j, '*');
//	                    encontrada = true;
//	                    break;
//	                }
//	            }
//	            if (!encontrada) resultado.set(i, "absent");
//	        }
//
//	        // Actualizar HashMap de letras
//	        for (int i = 0; i < LONGITUD_PALABRA; i++) {
//	            char letra          = intento.charAt(i);
//	            String estadoActual = estadoLetras.get(letra);
//	            String estadoNuevo  = resultado.get(i);
//
//	            if (estadoActual == null) {
//	                estadoLetras.put(letra, estadoNuevo);
//	            } else if (estadoActual.equals("absent") && !estadoNuevo.equals("absent")) {
//	                estadoLetras.put(letra, estadoNuevo);
//	            } else if (estadoActual.equals("present") && estadoNuevo.equals("correct")) {
//	                estadoLetras.put(letra, estadoNuevo);
//	            }
//	        }
//
//	        return resultado;
//	    }
//
//	    /**
//	     * Comprueba si el resultado es todo "correct" (palabra adivinada).
//	     *
//	     * @param resultado Resultado de evaluar()
//	     * @return true si todas las letras son correctas
//	     */
//	    public boolean esPalabraCorrecta(ArrayList<String> resultado) {
//	        for (String estado : resultado) {
//	            if (!estado.equals("correct")) return false;
//	        }
//	        return true;
//	    }
//
//	    /**
//	     * Acumula puntos al acertar una palabra.
//	     * Fórmula: 100 × vidas restantes.
//	     */
//	    public void sumarPuntuacion() {
//	        puntuacionAcumulada += 100 * vidasRestantes;
//	    }
//
//	    /**
//	     * Guarda el estado actual en fichero binario.
//	     */
//	    public void guardarEstado() {
//	        EstadoJuego estado = new EstadoJuego(
//	            palabraOculta, vidasRestantes,
//	            intentos, puntuacionAcumulada, estadoLetras
//	        );
//	        try (ObjectOutputStream oos = new ObjectOutputStream(
//	                new FileOutputStream(FICHERO_ESTADO))) {
//	            oos.writeObject(estado);
//	        } catch (IOException e) {
//	            System.err.println("Error al guardar: " + e.getMessage());
//	        }
//	    }
//
//	    /**
//	     * Carga el estado desde fichero binario.
//	     *
//	     * @return EstadoJuego leído, o null si no existe
//	     */
//	    public static EstadoJuego cargarEstado() {
//	        try (ObjectInputStream ois = new ObjectInputStream(
//	                new FileInputStream(FICHERO_ESTADO))) {
//	            return (EstadoJuego) ois.readObject();
//	        } catch (IOException | ClassNotFoundException e) {
//	            return null;
//	        }
//	    }
//
//	    // ── Getters ──────────────────────────────────────────────────
//	    public int getVidasRestantes()                     { return vidasRestantes; }
//	    public int getPuntuacionAcumulada()                { return puntuacionAcumulada; }
//	    public ArrayList<String> getIntentos()             { return intentos; }
//	    public HashMap<Character, String> getEstadoLetras(){ return estadoLetras; }
//	    public String getPalabraOculta()                   { return palabraOculta; }
//	    public boolean sinVidas()                          { return vidasRestantes <= 0; }
//	}