package edu.inmobiliaria;
/**
 * Prestamo que ofrece la inmobiliaria a un cliente para comprar un vivienda
 * @author Rafa
 * @version 1.0
 */
public class Prestamo {
	private static int numeroPrestamos;
	private Cliente cliente;
	private Vivienda vivienda;
	private float importe;
	private boolean aval;
	private float interes;
	private int duracion;
	private int numero;
	/**
	 * Construye un préstamo a partir del cliente, la vivienda, el importe del préstamo, si tiene aval, el inerés del préstamo
	 * y la duración del mismo
	 * @param cliente Cliente que solicita el préstamo
	 * @param vivienda Vivienda para la que se solicita el préstamo
	 * @param importe Importe del préstamo
	 * @param aval Disponibilidad de aval (true, dispone de aval)
	 * @param interes Interés del préstamo
	 * @param duracion Duración del préstamo en años
	 */
	public Prestamo(Cliente cliente, Vivienda vivienda, float importe, boolean aval, float interes, int duracion) {
		super();
		this.cliente = cliente;
		this.vivienda = vivienda;
		this.importe = importe;
		this.aval = aval;
		this.interes = interes;
		this.duracion = duracion;
		this.numero = numeroPrestamos++;
	}
	/**
	 * Dos préstamos son iguales si coinciden su cliente, vivienda y número de préstamo
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof Prestamo)) return false;
		Prestamo prestamo = (Prestamo)obj;
		if(prestamo.getCliente()==this.cliente
				&& prestamo.getVivienda()== this.vivienda
				&& prestamo.getNumero()==this.numero) return true;
		return false;
	}
	@Override
	public String toString() {
		return "Prestamo [cliente=" + cliente + ", vivienda=" + vivienda + ", importe=" + importe + ", aval=" + aval
				+ ", interes=" + interes + ", duracion=" + duracion + ", numero=" + numero + "]";
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Vivienda getVivienda() {
		return vivienda;
	}
	public float getImporte() {
		return importe;
	}
	public boolean isAval() {
		return aval;
	}
	public float getInteres() {
		return interes;
	}
	public int getDuracion() {
		return duracion;
	}

	public int getNumero() {
		return numero;
	}

	public static int getNumeroPrestamos() {
		return numeroPrestamos;
	}
}
