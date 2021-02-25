package edu.fichero.objetos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * Prueba para leer objetos de tipo Alumno de un fichero 
 * @author Rafa
 * @version 1.0
 */
public class TestSerializableLector {
	public static void main(String[] args) {
		ObjectInputStream lector=null;
		Alumno alumno = null;

		try {
			lector = new ObjectInputStream(new FileInputStream("alumnos.dat"));
			while((alumno=(Alumno)lector.readObject())!=null)
				System.out.println(alumno);
			
		}catch(EOFException e) {
			try {
				//se controla el final de fichero
				lector.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
