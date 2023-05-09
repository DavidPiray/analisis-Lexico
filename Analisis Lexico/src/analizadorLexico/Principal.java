package analizadorLexico;

import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.InputStream;

public class Principal {

	public static void main(String[] args) {
		//incluir el archivo de texto
		InputStream archivoStream = Principal.class.getResourceAsStream("divinaComedia.txt");

        // Verificar si se encontró el archivo
        if (archivoStream == null) {
            System.err.println("Archivo no encontrado");
            return;
        }
        
        
        String fragmento = "";
        try (Scanner scanner = new Scanner(archivoStream)) {
            // Leer el archivo línea por línea
        	 while (scanner.hasNextLine()) {
        		 //guardar todo el texto en una variable
                 fragmento += scanner.nextLine();
             }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Crear el StringTokenizer con el delimitador por defecto (espacio en blanco y puntuación)
        StringTokenizer tokenizer = new StringTokenizer(fragmento);

        // Definir las palabras a rastrear
        String[] palabras = {"alto", "viva", "persona", "cielo"};

        // Inicializar el contador de ocurrencias para cada palabra
        int[] ocurrencias = new int[palabras.length];

        // Recorrer el fragmento tokenizado
        while (tokenizer.hasMoreTokens()) {
            // Obtener el siguiente token
            String token = tokenizer.nextToken();

            // Eliminar puntuación del token
            token = token.replaceAll("[^a-zA-Z]", "");

            // Comparar el token con cada palabra
            for (int i = 0; i < palabras.length; i++) {
                if (token.equalsIgnoreCase(palabras[i])) {
                    // Incrementar el contador de ocurrencias de la palabra
                    ocurrencias[i]++;
                }
            }
        }
        
        // Mostrar los resultados
        
            System.out.println("El archivo contiene lo siguiente: ");
            System.out.println(fragmento);
            System.out.println("----------------------------------------");
            System.out.println("Los resultados son los siguientes: ");
            System.out.print("Palabra: alto: ");
            System.out.println(ocurrencias[0]);
            System.out.print("Palabra: viva: ");
            System.out.println(ocurrencias[1]);
            System.out.print("Palabra: persona: ");
            System.out.println(ocurrencias[2]);
            System.out.print("Palabra: cielo: ");
            System.out.println(ocurrencias[3]);

        
	}

}
