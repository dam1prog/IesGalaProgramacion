package edu.fichero.objetos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * Prueba para guardar objetos de tipo Alumno en un fichero
 * @author Rafa
 * @version 1.0
 */
public class TestSerializableEscritor {

	public static void main(String[] args) {
		ObjectOutputStream escritor=null;

		try {
			escritor = new ObjectOutputStream(new FileOutputStream("alumnos.dat",true));
			escritor.writeObject(new Alumno("aaaaaaa","12345678A",20));
			escritor.writeObject(new Alumno("bbbbbbb","98765432B",21));
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
