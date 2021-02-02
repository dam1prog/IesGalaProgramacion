package edu.inmobiliaria;
/**
 * Cliente de la inmobiliaria
 * @author Rafa
 * @version 1.0
 */
public class Cliente {
	private String dni;
	private String nombre;
	private int edad;
	private String domicilio;
	/**
	 * Crea objetos de tipo cliente a partir de su dnni, nombre, edad y domicilio
	 * @param dni
	 * @param nombre
	 * @param edad
	 * @param domicilio
	 */
	public Cliente(String dni, String nombre, int edad, String domicilio) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
	}
	/**
	 * Dos clientes son la misma persona si tienen el mismo DNI
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof Cliente)) return false;
		if(((Cliente)obj).getDni().equals(this.dni)) return true;
		return false;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", domicilio=" + domicilio + "]";
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
}
