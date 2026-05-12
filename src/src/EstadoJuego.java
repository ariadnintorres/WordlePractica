package src;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa El estado del juego para guardarlo en fichero binario
 * Implementa Serializable para poder usar ObjectOutpuStream 
 * 
 * @author ariad
 */



public class EstadoJuego implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private String palabraOculta;
	private int vidasRestantes;
	private ArrayList<String> intentos;
	private int puntuacionAcumulada;
	
	
	/**
	 * Constructor de EstadoJuego
	 * 
	 * *
     * @param palabraOculta       Palabra secreta actual
     * @param vidasRestantes      Vidas que le quedan al jugador
     * @param intentos            Lista de palabras ya intentadas
     * @param puntuacionAcumulada Puntuación total hasta ahora
     */
	 
	public EstadoJuego(String palabraOculta, int vidasRestantes, ArrayList<String> intentos, int puntuacionAcumulada) {
		super();
		this.palabraOculta = palabraOculta;
		this.vidasRestantes = vidasRestantes;
		this.intentos = intentos;
		this.puntuacionAcumulada = puntuacionAcumulada;
	}
	
	
	
	public String getPalabraOculta() { return palabraOculta;}
	public int getVidasRestantes() { return vidasRestantes;}
	public ArrayList<String> getIntentos() { return intentos; }
	public int getPuntuacionAcumulada()    { return puntuacionAcumulada; }


	
}
