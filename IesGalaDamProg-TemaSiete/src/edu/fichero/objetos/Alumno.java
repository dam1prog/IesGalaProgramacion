package edu.fichero.objetos;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.Serializable;

public class Alumno implements Serializable{
	private static final long serialVersionUID = 4745698430499590219L;
	private static int contador=0;
	private String nombre;
	private String dni;
	private transient int numero;
	private int edad;
	
	public Alumno(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + "]";
	}
	
	private void readObject(java.io.ObjectInputStream in)
		     throws IOException, ClassNotFoundException{
		//reflexión sobre las propiedades de los objetos
		GetField fields = in.readFields();
		//ahora es posible acceder a los valores de las propiedades por su nombre
		this.dni = fields.get("dni","").toString();
		this.nombre = fields.get("nombre","").toString();
		
		//si usamos la reflexión no podemos utilizar la lectura de valores de propiedades
		//proporcionada por el mecanismo de serialización. O lo anterior o la línea siguiente
		//in.defaultReadObject();

		//propiedad transiente, se inicializa de manera personalizada. Su valor no se guarda
		//ni se obtiene del fichero de objetos
		this.numero = ++contador;
	}
}
