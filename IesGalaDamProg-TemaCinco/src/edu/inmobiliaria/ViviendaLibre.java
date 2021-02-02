package edu.inmobiliaria;

public class ViviendaLibre extends Vivienda {
	private int beneficio;
	/**
	 * Constructor para viviendas libres a partir de las propiedades heredadas de Vivienda y aportando además el beneficio
	 * @param direccion Dirección de la vivienda
	 * @param superficie Superficie de la vivienda en metros cuadrados
	 * @param descripcion Descripción de la vivienda
	 * @param estado Estado: NUEVA, DERRUMBE o REFORMA
	 * @param precio Precio actual
	 * @param beneficio Beneficio que obtiene la inomobiliaria por la venta
	 */
	public ViviendaLibre(String direccion, int superficie, String descripcion, int estado, float precio, int beneficio) {
		super(direccion, superficie, descripcion, estado, precio);
		this.beneficio = beneficio;
	}
	
	public int getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}

	@Override
	public String toString() {
		return "ViviendaLibre [beneficio=" + beneficio + "]" + super.toString();
	}
}
