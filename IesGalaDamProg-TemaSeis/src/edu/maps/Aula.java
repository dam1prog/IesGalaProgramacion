package edu.maps;

import java.io.Serializable;
/**
 * Clase para el aula del centro educativo
 * @author Rafa
 * @version 1.0
 */
public class Aula implements Serializable {
	private String localizacion;
	private String numero;
	
	public Aula(String numero, String localizacion) {
		this.localizacion = localizacion;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Aula [localizacion=" + localizacion + ", numero=" + numero + "]";
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getNumero() {
		return numero;
	}
}
