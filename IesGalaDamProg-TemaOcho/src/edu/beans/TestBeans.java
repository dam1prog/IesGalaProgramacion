package edu.beans;

import java.time.LocalDate;

import javafx.beans.property.ReadOnlyProperty;

public class TestBeans {

	public static void main(String[] args) {
		Persona p = new Persona();

		System.out.println("--- valores iniciales --- ");

		printDetails(p.idProperty());
		printDetails(p.nombreProperty());
		printDetails(p.fechaProperty());

		System.out.println("--- nuevos valores --- ");

		p.setNombre("1º DAM Gala Programación");
		p.setFecha(LocalDate.now());

		printDetails(p.idProperty());
		printDetails(p.nombreProperty());
		printDetails(p.fechaProperty());

	}
	/**
	 * Método para imprimir toda la información asociada con una propiedad del bean
	 * @param p Propiedad de la que se mostrará información
	 */
	public static void printDetails(ReadOnlyProperty<?> p) {
	    String name = p.getName();
	    Object value = p.getValue();
	    Object bean = p.getBean();

	    String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
	    String propClassName = p.getClass().getSimpleName();

	    System.out.print(propClassName);
	    System.out.print("[Nombre:" + name);
	    System.out.print(", Clase Bean:" + beanClassName);
	    System.out.println(", Valor:" + value + "]");
	}

}
