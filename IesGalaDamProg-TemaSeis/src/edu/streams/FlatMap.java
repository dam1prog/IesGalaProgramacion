package edu.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/**
 * Clase para probar el método flatMap de Stream. Convierte una lista de listas en una lista de cadenas
 * @author Rafa
 * @version 1.0
 */
public class FlatMap {
	public static void main(String[] args) {
		List<List<String>> collection = Arrays.asList(Arrays.asList("Dani", "Álvaro"), Arrays.asList("Ionut", "Isaías", "Jonatan"));
		System.out.println("Sin flatMap");
		List<String> newCollection = new ArrayList<>();
		for (List<String> subCollection : collection) {
			for (String value : subCollection) {
				newCollection.add(value);
			}
		}
		newCollection.stream().forEach(s->System.out.println(s));;
		System.out.println("\nCon flatMap");
		collection.stream().flatMap(result->result.stream()).collect(Collectors.toList()).forEach(s->System.out.println(s));
	}
	
}
