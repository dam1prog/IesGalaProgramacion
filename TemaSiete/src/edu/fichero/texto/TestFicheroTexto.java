package edu.fichero.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Clase en la que se muestra un ejemplo para crear un fichero de texto
 * @author Rafa
 */
public class TestFicheroTexto {
	public static void main(String[] args) {	
		PrintWriter writer = null;
		BufferedReader reader = null;
		String cadena="";
		try {
			writer = new PrintWriter(
					new FileWriter("datos.txt"));
			for(int i=0;i<5;i++) {
				writer.println("Flujos de ficheros en Java " + i);
			}
			writer.close();
			reader = new BufferedReader(new FileReader("datos.txt"));
			cadena = reader.readLine();
			while(cadena!=null) {
				System.out.println(cadena);
				cadena = reader.readLine();
			}			
		} catch (IOException e) {
			System.out.println("Se ha producido un error al intentar escribir en el fichero");
		} finally {			
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Se ha producido un error al cerrar el fichero");
			}
		}			
	}
}
