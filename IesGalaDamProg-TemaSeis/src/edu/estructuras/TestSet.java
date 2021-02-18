package edu.estructuras;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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
		//permite añadir elementos nulos
		hashSetA.add(null);
		//no añade el siguiente objeto porque ya existe
		hashSetA.add(empleado);
		//el siguiente objeto tiene las mismas propiedades que el anterior pero distinta instancia
		hashSetA.add(new Empleado("Ionut",20));

		hashSetB.add(new Empleado("José María",27));
		hashSetB.add(new Empleado("David",22));
		System.out.println("Ejemplo de HashSet");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Conjuntos A y B antes de la unión");
		System.out.println("A");
		for(Empleado emp:hashSetA)
			System.out.println(emp);
		System.out.println("B");
		for(Empleado emp:hashSetB)
			System.out.println(emp);

		//unión de conjuntos
		hashSetA.addAll(hashSetB);
		System.out.println("\nConjuntos A y B unidos");
		for(Empleado emp:hashSetA)
			System.out.println(emp);

		//intersección de conjuntos
		hashSetA.retainAll(hashSetB);
		System.out.println("\nConjuntos A y B, intersección");
		for(Empleado emp:hashSetA)
			System.out.println(emp);

		//Implementación de la interfaz Set a través de una tabla Hash y una lista enlazada, en la que el
		//orden de los elementos es el orden de inserción. El orden inserción no se ve afectado en 
		//sucesivas inserciones en el conjunto
		//Una de las principales diferencias con HashSet es que mantiene un doble enlace a los elementos,
		//desde la tabla Hash al primer elemento de la lista y entre elementos de la lista. 

		System.out.println("\n\nEjemplo de LinkedHashSet");
		System.out.println("---------------------------------------------------------------------");
		LinkedHashSet<Empleado> lhs = new LinkedHashSet<Empleado>();
		empleado = new Empleado("Ionut",20);
		lhs.add(empleado);
		lhs.add(new Empleado("Raúl",33));
		lhs.add(new Empleado("David",22));
		lhs.add(new Empleado("Samuel",21));
		//permite añadir elementos nulos
		lhs.add(null);
		//no añade el siguiente objeto porque ya existe
		lhs.add(empleado);
		//el siguiente objeto tiene las mismas propiedades que el anterior pero distinta instancia
		lhs.add(new Empleado("Ionut",20));
		System.out.println("Conjunto LHS");
		for(Empleado emp:lhs)
			System.out.println(emp);

		System.out.println("\nA");
		for(Empleado emp:hashSetA)
			System.out.println(emp);
		//se combinan los dos tipos de conjuntos
		lhs.addAll(hashSetA);

		System.out.println("\nSe obtiene la combinación de dos tipos de conjuntos LHS y A");

		for(Empleado emp:lhs)
			System.out.println(emp);
		
		//El TreeSet es un árbol binario ordenado, incluso si no se indica
		//un comparador explícito. Usará por tanto equals()
		//En este ejemplo los empleados se muestran según el orden alfabético de sus nombres
		System.out.println("\n\nEjemplo de TreeSet");
		System.out.println("---------------------------------------------------------------------");
		TreeSet<Empleado> treeSet = new TreeSet<Empleado>();
		treeSet.add(new Empleado("Santiago",33));
		treeSet.add(new Empleado("David",22));
		treeSet.add(new Empleado("Carlos",21));
		System.out.println("\nTreeSet");
		for(Empleado emp:treeSet)
			System.out.println(emp);
		
		System.out.println("LHS");
		for(Empleado emp:lhs)
			System.out.println(emp);
		
		System.out.println("\nDiferencia entre conjuntos: TreeSet y LinkedHashSet");
		lhs.removeAll(treeSet);
		for(Empleado emp:lhs)
			System.out.println(emp);
		
	}

}
