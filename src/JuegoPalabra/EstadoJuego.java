package JuegoPalabra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
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
	private HashMap<Character, String> estadoLetras;


	/**
	 * Constructor de EstadoJuego
	 * 
	 * *
	 * @param palabraOculta       Palabra secreta actual
	 * @param vidasRestantes      Vidas que le quedan al jugador
	 * @param intentos            Lista de palabras ya intentadas
	 * @param puntuacionAcumulada Puntuación total hasta ahora
	 */

	public EstadoJuego(String palabraOculta, int vidasRestantes,
			ArrayList<String> intentos, int puntuacionAcumulada,
			HashMap<Character, String> estadoLetras) {
		this.palabraOculta        = palabraOculta;
		this.vidasRestantes       = vidasRestantes;
		this.intentos             = new ArrayList<>(intentos);
		this.puntuacionAcumulada  = puntuacionAcumulada;
		this.estadoLetras         = new HashMap<>(estadoLetras);
	}

	public String getPalabraOculta()
	{ return palabraOculta; }

	public int getVidasRestantes()                     
	{ return vidasRestantes; }

	public ArrayList<String> getIntentos()            
	{ return intentos; }

	public int getPuntuacionAcumulada()                
	{ return puntuacionAcumulada; }

	public HashMap<Character, String> getEstadoLetras()
	{ return estadoLetras; }
}

