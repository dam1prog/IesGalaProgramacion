package edu.serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerializacionEscritura {

	public static void main(String[] args) {
		ObjectOutputStream escritor=null;		
		try {
			escritor = new ObjectOutputStream(new FileOutputStream("alumnosv1.dat"));
			Alumno alumno = new Alumno("11111111A",20,"1ºSMR");
			escritor.writeObject(alumno);
			alumno = new Alumno("22222222B",19,"1ºDAM");
			escritor.writeObject(alumno);			
			escritor.close();
			
			escritor = new ObjectOutputStream(new FileOutputStream("alumnosv2.dat"));
			alumno = new Alumno("67677788G",21,"1ºSMR","Fran");
			escritor.writeObject(alumno);
			alumno = new Alumno("87654321N",22,"1ºDAM","Loli");
			escritor.writeObject(alumno);
			escritor.flush();		
		}catch (IOException e) {
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

