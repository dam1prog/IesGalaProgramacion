package edu.inmobiliaria;
/**
 * Vivienda disponible para venta en la inmobiliaria. Puede ser de tipo libre o de protección oficial
 * @author Rafa
 * @version 1.0
 *
 */
public class Vivienda {
	public final static int NUEVA=100;
	public final static int DERRUMBE=101;
	public final static int REFORMA=102;
	private static int numeroViviendas;
	private String direccion;
	private int superficie;
	private String descripcion;
	private int estado;
	private float precio;
	private int numero;
	/**
	 * Construye viviendas a partir de su dirección, superficie, descripción, estado y precio
	 * @param direccion Dirección de la vivienda
	 * @param superficie Superficie de la vivienda en metros cuadrados
	 * @param descripcion Descripción de la vivienda
	 * @param estado Estado: NUEVA, DERRUMBE o REFORMA
	 * @param precio Precio actual
	 */
	public Vivienda(String direccion, int superficie, String descripcion, int estado, float precio) {
		this.direccion = direccion;
		this.superficie = superficie;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
		this.numero = numeroViviendas++;
	}
	/**
	 * Dos viviendas son iguales si coincide su número
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof ViviendaProtegida) || !(obj instanceof ViviendaLibre)) return false;
		if(((Vivienda)obj).getNumero()==this.getNumero()) return true;
		return false;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public static int getNumeroViviendas() {
		return numeroViviendas;
	}
	public int getNumero() {
		return numero;
	}
}
