package JuegoPalabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestorPalabras {
    private ArrayList<String> palabras;

    public GestorPalabras() {
        palabras = new ArrayList<>();
    }

    public void cargarPalabras(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                for (String p : partes) {
                    String palabra = p.trim().toLowerCase();
                    if (palabra.length() == 5) {
                        palabras.add(palabra);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar palabras: " + e.getMessage());
        }
    }

    public ArrayList<String> getPalabras() { return palabras; }

  public String getPalabraAleatoria() {
        Random rand = new Random();
        return palabras.get(rand.nextInt(palabras.size()));
    }
}