package edu.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
/**
 * Clase con ejemplos de creación de streams
 * @author Rafa
 * @version 1.0
 */
public class TestStreamsDos {

	public static void main(String[] args) {
		//creamos un stream vacío, podemos usarlo para devolver un stream vacío en vez de nulo
		Stream<String> streamEmpty = Stream.empty();
		System.out.println(streamEmpty.count());
		
		//crear un stream a partir de una colección de alguno de los tipos: Collection, List o Set
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		streamOfCollection.forEach(c->System.out.print(c + " "));

		//crear un stream a partir de un array o parte de un array
		String[] arr = new String[]{"b", "a", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		System.out.println();
		streamOfArrayFull.forEach(c->System.out.print(c + " "));
		System.out.println();
		streamOfArrayPart.forEach(c->System.out.print(c + " "));
		System.out.println();
		
		//crear un stream indicando el tipo de objeto con un builder
		Stream<String> streamBuilder =
				Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(c->System.out.print(c + " "));
		
		System.out.println();
		//crear un stream utilizando un proveedor para la generación de los elementos del mismo
		//se indica el tamaño del stream, en caso contrario el método generate() creará
		//un número infinito de elementos hasta agotar la memoria
		Stream<String> streamGenerated =
			  Stream.generate(() -> "element").limit(10);
		streamGenerated.forEach(c->System.out.print(c + " "));
		
		System.out.println();
		//crear un stream utilizando un iterador. Al igual que antes se debe indicar
		//un límite de elementos del stream
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		streamIterated.forEach(c->System.out.print(c + " "));
	}

}
