package edu.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamsUno {
	private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	public TestStreamsUno() {
		listaAlumnos.add(new Alumno(1, "Javier Ignacio", "Molina Cano", "Java 8", 7, 28));
		listaAlumnos.add(new Alumno(2, "Lillian Eugenia", "Gómez Álvarez", "Java 8", 10, 33));
		listaAlumnos.add(new Alumno(3, "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
		listaAlumnos.add(new Alumno(4, "Gerardo Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
		listaAlumnos.add(new Alumno(5, "Jhony Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
		listaAlumnos.add(new Alumno(6, "Germán Antonio", "Lotero Upegui", "Java 8", 8, 34));
		listaAlumnos.add(new Alumno(7, "Oscar Darío", "Murillo González", "Java 8", 8, 32));
		listaAlumnos.add(new Alumno(8, "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
		listaAlumnos.add(new Alumno(9, "César Oswaldo", "Alzate Agudelo", "Java 8", 8, 26));
		listaAlumnos.add(new Alumno(10, "Gloria Amparo", "González Castaño", "PHP", 10, 28));
		listaAlumnos.add(new Alumno(11, "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
		listaAlumnos.add(new Alumno(12, "John Jairo", "Duque García", "Java Script", 9.4, 32));
		listaAlumnos.add(new Alumno(13, "Julio Cesar", "González Castaño", "C Sharp", 10, 22));
		listaAlumnos.add(new Alumno(14, "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
		listaAlumnos.add(new Alumno(15, "Gabriel Jaime", "Jiménez Gómez", "Java Script", 10, 18));
	}
	public static void main(String[] args) {
		TestStreamsUno testLambda = new TestStreamsUno();
		testLambda.mostrarAlumnos(true);
		//mostrar los alumnos cuyo nombre empiece por G o L
		testLambda.mostrarAlumnos(false).
		filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G')
				.forEach(c -> System.out.println(c));
		
		//podemos contar el número de alumnos que han obtenido una calificación superior a 9
		// en el curso Java 8
		System.out.println(testLambda.mostrarAlumnos(false).filter(a->a.getNota()>9
				&& a.getNombreCurso().equals("Java 8")).count());
		
		//obtener el alumno que tiene menor edad
		System.out.println(testLambda.mostrarAlumnos(false).
				min((a1, a2) -> a1.getEdad() - a2.getEdad()).get());
		
		//obtener el alumno que tiene la mayor edad
		System.out.println(testLambda.mostrarAlumnos(false).
				max((a1, a2) -> a1.getEdad() - a2.getEdad()).get());
		
		//obtener los alumnos cuyo nombre de curso terminan en 't'
		testLambda.mostrarAlumnos(false).
				filter(a -> a.getNombreCurso().endsWith("t")).forEach(System.out::println);
		
		//mostrar los alumnos que están en un curso que contenga el carácter 'a'
		testLambda.mostrarAlumnos(false).
		filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);

		//mostrar los alumnos cuyo nombre tiene una longitud mayor de 10 caracteres
		testLambda.mostrarAlumnos(false).
		filter(a -> a.getNombres().length() > 10).forEach(System.out::println);
		
		//alumnos cuyo nombre empieze por 'P' y la longitud del mismo sea menor o igual que 6
		Predicate<Alumno> empiezaConP = a -> a.getNombreCurso().startsWith("P");
		Predicate<Alumno> longitud = a -> a.getNombreCurso().length() <= 6;
		
		testLambda.mostrarAlumnos(false).
		filter(empiezaConP.and(longitud)).forEach(System.out::println);
		
		//ahora vamos a obtener una nueva lista a partir del Stream de alumnos cuyo nombre de curso
		//contengan la letra 'a'
		List<Alumno> nuevaLista= testLambda.mostrarAlumnos(false).
				filter(a -> a.getNombreCurso().contains("a")).collect(Collectors.toList());
		nuevaLista.forEach(System.out::println);
	}
	
	public Stream<Alumno> mostrarAlumnos(boolean mostrar) {
		Stream alumnos = this.listaAlumnos.stream();
		if(mostrar)
			alumnos.forEach(t->System.out.println(t));
		return alumnos;
	}
}