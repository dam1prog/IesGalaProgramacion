package edu.arrays;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		Persona persona1 = new Persona("aaaa",23);
		Persona persona2 = new Persona("bbbb",21);
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(persona1);
		personas.add(persona2);
		
		personas.remove(new Persona("aaaa",23));
		
		for(Persona persona:personas) {
			System.out.println(persona);
		}
	}

}
