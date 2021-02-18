package edu.arrays;

import java.util.Comparator;

public class Empleado extends Persona implements Comparator,Comparable{
	private String departamento;
	{
		this.departamento="Técnico";
	}
	public Empleado(String nombre, int edad) {
		super(nombre,edad);
	}
	protected void setDepartamento() {
		if(this.edad>25 && super.edad<40)
			this.departamento = "Comercial";
	}
	@Override
	public int compareTo(Object o) {
		return this.nombre.compareTo(((Empleado)o).nombre);
	}
	@Override
	public int compare(Object o1, Object o2) {
		return ((Empleado)o1).nombre.compareTo(((Empleado)o2).nombre);
	}
	
	
}
