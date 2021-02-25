package edu.serializacion;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Alumnos del curso 1º DAM
 * @author usuario
 * @version 2.0
 */
public class Alumno implements Serializable {
	private static final long serialVersionUID = -6481165921263945871L;
	private static int contador;
	private int edad;
	private String curso;
	private String dni;
	//nueva propiedad en la versión 2
	private String tutor;
	private static int version;
	private transient int numero;
	private Aula aula;
	
	/**
	 * Constructor para la versión 1, no tiene tutor
	 * @param dni
	 * @param edad
	 * @param curso
	 */
	public Alumno(String dni, int edad,String curso) {		
		this.dni = dni;
		this.curso = curso;
		this.edad = edad;		
	}	
	
	/**
	 * Constructor para la version 2, tiene tutor
	 * @param dni
	 * @param edad
	 * @param curso
	 * @param tutor
	 */
	public Alumno(String dni, int edad,String curso,String tutor) {		
		this.dni = dni;
		this.curso = curso;
		this.edad = edad;
		this.tutor = tutor;
	}		
	
	
	@Override
	public String toString() {
		return "Alumno [edad=" + edad + ", curso=" + curso + ", dni=" + dni + ", tutor=" + tutor + ", numero=" + numero
				+ ",version=" + version +"]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException{
		
		if(this.tutor==null)
			version = 1;			
		else
			version=2;
		
		out.writeInt(version);	
		
		out.defaultWriteObject();		
	}
		
	private void readObject(java.io.ObjectInputStream in)
		     throws IOException, ClassNotFoundException{
		//se leen del flujo de objetos inicializando todas las propiedades
		//de cada objeto que no sean ni transient, ni estáticas
		version = in.readInt();
		
		GetField fields = in.readFields();		
		
		this.dni = fields.get("dni", "No existe").toString();
		this.curso = fields.get("curso", "No asignado").toString();
		this.edad = fields.get("edad", 0);
		
		if(version ==1) {		
			this.tutor="No Asignado";			
		}else {
			this.tutor = fields.get("tutor", "No asignado").toString();
		}
						
		this.setNumAlumno();
	}
	
	private void setNumAlumno() {
		contador++;
		this.numero = contador;
	}
}
