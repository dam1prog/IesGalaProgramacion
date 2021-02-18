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
		/*if(this.edad>((Empleado)o).edad) return -1;
		if(this.edad<((Empleado)o).edad) return 1;
		return 0;*/
		return this.nombre.compareTo(((Empleado)o).nombre);
	}
	@Override
	public int compare(Object o1, Object o2) {
		/*if(((Empleado)o1).edad>((Empleado)o2).edad) return -1;
		if(((Empleado)o1).edad<((Empleado)o2).edad) return 1;
		return 0;*/
		return ((Empleado)o1).nombre.compareTo(((Empleado)o2).nombre);
	}
	@Override
	public boolean equals(Object obj) {
		return this.nombre.equals(((Empleado)obj).nombre);
		//return this.edad==((Empleado)obj).edad;
	}
	@Override
	public int hashCode() {
		return this.nombre==null?0:this.nombre.hashCode();
	}
}
