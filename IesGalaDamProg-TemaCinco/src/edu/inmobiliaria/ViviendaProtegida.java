package edu.inmobiliaria;
/**
 * Vivienda de protección oficial
 * @author Rafa
 * @version 1.0
 */
public class ViviendaProtegida extends Vivienda {
	/**
	 * Constructor para vivienda protegida a partir de todas sus propiedades heredadas
	 * @param direccion Dirección de la vivienda
	 * @param superficie Superficie de la vivienda en metros cuadrados
	 * @param descripcion Descripción de la vivienda
	 * @param estado Estado: NUEVA, DERRUMBE o REFORMA
	 * @param precio Precio actual
	 */
	public ViviendaProtegida(String direccion, int superficie, String descripcion, int estado, float precio) {
		super(direccion, superficie, descripcion, estado, precio);
	}

	@Override
	public String toString() {
		return "ViviendaProtegida [toString()=" + super.toString() + "]";
	}
}
