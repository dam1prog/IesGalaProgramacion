package edu.inmobiliaria;

import java.time.LocalDateTime;
/**
 * Visitas realizadas por un cliente a una vivienda en un momento determinado
 * @author Rafa
 * @version 1.0
 */
public class Visita {
	private LocalDateTime momento;
	private String valoracion;
	private Cliente cliente;
	private Vivienda vivienda;
	/**
	 * Construye objetos de tipo visita a partir del momento de la visita, la valoración del cliente, el cliente y la vivienda visitada
	 * @param momento Instante de la visita
	 * @param valoracion Valoración del cliente en relación a la vivienda visitada
	 * @param cliente Cliente que realiza la visita
	 * @param vivienda Vivienda visitada
	 */
	public Visita(LocalDateTime momento, String valoracion, Cliente cliente, Vivienda vivienda) {
		super();
		this.momento = momento;
		this.valoracion = valoracion;
		this.cliente = cliente;
		this.vivienda = vivienda;
	}
	/**
	 * Dos visitas son iguales si coinciden el momento, el cliente y la vivienda
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof Visita)) return false;
		Visita visita = (Visita)obj;
		if((visita.getMomento()==this.momento
				&& visita.getCliente().equals(this.cliente))
				&& visita.getVivienda().equals(this.vivienda))return true;
		return false;
	}

	@Override
	public String toString() {
		return "Visita [momento=" + momento + ", valoracion=" + valoracion + ", cliente=" + cliente + ", vivienda="
				+ vivienda + "]";
	}

	public LocalDateTime getMomento() {
		return momento;
	}
	public String getValoracion() {
		return valoracion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Vivienda getVivienda() {
		return vivienda;
	}
	
}
