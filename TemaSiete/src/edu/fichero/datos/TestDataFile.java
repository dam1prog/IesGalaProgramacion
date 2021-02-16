package edu.fichero.datos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * Clase en la que se muestra un ejemplo de lectura y escritura en un fichero de acceso
 * aleatorio.
 * @author Rafa
 * @version 1.0
 */
public class TestDataFile {
	private static final int LON_NOMBRE=40;
	private static final int LON_REGISTRO=84;
	 
	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[3];
		TestDataFile testDataFile = new TestDataFile();
		testDataFile.createFile();
		
//		alumnos[0] = new Alumno("Carlos",22);
//		alumnos[1] = new Alumno("David",21);
//		alumnos[2] = new Alumno("Félix",24);
						
		if(testDataFile.createFile()) {
			//testDataFile.writeData(alumnos);
			alumnos = testDataFile.readData();
			for(int i=0;i<alumnos.length;i++)
				System.out.println(alumnos[i]);
		}
	}
	/**
	 * Crear el fichero si no existe
	 * @return Un valor booleano indicando si ha sido posible crear el fichero (true)
	 */
	private boolean createFile() {
		File file = new File("alumnos.dat");
		try {
			if(!file.exists())
				file.createNewFile();			
		} catch (IOException e1) {				
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Guarda un array de alumnos en un fichero de acceso aleatorio
	 * @param alumnos Array de alumnos a guardar en el fichero
	 * @return Devuelve el número de alumnos guardados en el fichero, -1 indica un error al guardar
	 */
	private int writeData(Alumno[] alumnos) {
		RandomAccessFile raf = null;
		int contador=0;
		String nombre="";
		try {
			raf = new RandomAccessFile("alumnos.dat","rw");	
			
			for(int i=0;i<alumnos.length;i++) {
				nombre = this.fixedFieldLength(LON_NOMBRE, alumnos[i].getNombre());
				for(int j=0;j<nombre.length();j++)
					raf.writeChar(nombre.charAt(j));
				raf.writeInt(alumnos[i].getEdad());
				contador++;
			}						
		} catch (IOException e) {			
			e.printStackTrace();
			return -1;
		}finally {
			try {
				raf.close();
			} catch (IOException e) {				
				e.printStackTrace();
				return -1;
			}
		}
		return contador;
	}
	/**
	 * Lee de un fichero de acceso aleatorio todos los registros de alumnos y los
	 * devuelve en un array
	 * @return Array de alumnos cuyos datos se han obtenido del fichero
	 */
	private Alumno[] readData() {
		Alumno[] alumnos=null;
		int numRegistros;
		int edad;
		File file = new File("alumnos.dat");
		if(!file.exists()
				|| file.length()==0) return alumnos;
		try {
			RandomAccessFile raf = new RandomAccessFile("alumnos.dat","r");
			numRegistros = (int)file.length() /LON_REGISTRO;
			alumnos = new Alumno[numRegistros];
			for(int i=0;i<numRegistros;i++) {
				StringBuffer nombre = new StringBuffer(LON_NOMBRE);
				int j = 0;
				while (j < LON_NOMBRE)
				{
					char ch = raf.readChar();					
					if (ch != ' ')						
						nombre.append(ch);	
					j++;
				}
			    edad = raf.readInt();
			    alumnos[i] = new Alumno(nombre.toString(),edad);
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		return alumnos;
	}
	
	/**
	 * Convierte una cadena de longitud variable en una cadena de longitud fija, los caracteres
	 * que faltan los completa con espacios en blanco
	 * @param len Tamaño de la cadena de longitud fija
	 * @param value Cadena de longitud variable que se convertirá en una cadena de longitud fija
	 * @return Devuelve la misma cadena de entrada pero con longitud fija de 'len' caracteres
	 */
	private String fixedFieldLength(int len, String value) {
		String result="";
		StringBuffer sb = new StringBuffer(len);
		sb.append(value);
		for(int i=value.length();i<len;i++)
			sb.append(" ");
		
		result = sb.toString();
		
		return result;
	}
}
