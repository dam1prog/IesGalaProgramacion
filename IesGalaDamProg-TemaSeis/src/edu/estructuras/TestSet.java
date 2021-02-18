package edu.estructuras;

import java.util.HashSet;

import edu.arrays.Empleado;
/**
 * Ejemplo de uso de HashSet 
 * @author Rafa
 * @version 1.0
 */
public class TestSet {

	public static void main(String[] args) {
		//Conjunto de objetos para el que se utiliza cuyos elementos se identifican internamente
		//mediante un código hash. Dicho código se basa en las propiedades de los objetos.
		//HashSet no admite elementos duplicados, no ordena los elementos
		HashSet<Empleado> hashSetA=new HashSet<Empleado>();
		HashSet<Empleado> hashSetB=new HashSet<Empleado>();
		Empleado empleado = new Empleado("Ionut",20);
		hashSetA.add(empleado);
		hashSetA.add(new Empleado("Raúl",33));
		hashSetA.add(new Empleado("David",22));
		hashSetA.add(new Empleado("Samuel",21));
		//no añade el siguiente objeto porque ya existe
		hashSetA.add(empleado);
		//el siguiente objeto tiene las mismas propiedades que el anterior pero distinta instancia
		hashSetA.add(new Empleado("Ionut",20));
		
		hashSetB.add(new Empleado("José María",27));
		hashSetB.add(new Empleado("David",22));
		
		System.out.println("Conjuntos A y B antes de la unión");
		System.out.println("A");
		for(Empleado emp:hashSetA)
			System.out.println(emp);
		System.out.println("B");
		for(Empleado emp:hashSetB)
			System.out.println(emp);
		
		//unión de conjuntos
		hashSetA.addAll(hashSetB);
		System.out.println("Conjuntos A y B unidos");
		for(Empleado emp:hashSetA)
			System.out.println(emp);
		
		
		//intersección de conjuntos
		hashSetA.retainAll(hashSetB);
		System.out.println("Conjuntos A y B en intersección");
		for(Empleado emp:hashSetA)
			System.out.println(emp);
	}

}
