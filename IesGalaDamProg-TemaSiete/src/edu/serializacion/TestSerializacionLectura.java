package edu.serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestSerializacionLectura {

	public static void main(String[] args) {		
		ObjectInputStream lector=null;
		try {		
			//lectura de la versión 1 de objetos de la clase Alumno
			lector = new ObjectInputStream(new FileInputStream("alumnosv1.dat"));
			Alumno alumno=null;

			try {
			while((alumno=(Alumno)lector.readObject())!=null)
				System.out.println(alumno);
			
			}catch(EOFException e) {
				lector.close();
			}
			
			//lectura de objetos de la versión 2 de la clase Alumno
			lector = new ObjectInputStream(new FileInputStream("alumnosv2.dat"));
			alumno=null;
			try {
			while((alumno=(Alumno)lector.readObject())!=null)
				System.out.println(alumno);

			}catch(EOFException e) {
				lector.close();
			}

		}catch(ClassNotFoundException e) {

		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
