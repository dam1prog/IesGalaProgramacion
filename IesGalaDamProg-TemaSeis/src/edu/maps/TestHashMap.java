package edu.maps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
/**
 * Ejemplo de HashMap y flujo de objetos
 * @author Rafa
 * @version 1.0
 */
public class TestHashMap {

	public static void main(String[] args) {
		ObjectInputStream lector =null;
		HashMap<Integer,Aula> hashMap = new HashMap<Integer, Aula>();
		
		/*El fichero aulas.dat contien un mapa de objetos de tipo Aula
		 *son los siguientes: new Aula("b139","primera planta");
		,new Aula("b128","planta baja");
		,new Aula("b121","planta baja");*/
		
		try {
			//se lee el mapa de Aulas desde un fichero de objetos
			lector = new ObjectInputStream(new FileInputStream("aulas.dat"));
			hashMap = (HashMap<Integer, Aula>)lector.readObject();
			lector.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Elementos en el mapa:" + hashMap.size());
		System.out.println("Contiene la clave 2?: " + hashMap.containsKey(2));
		
		Aula aula = hashMap.put(2, new Aula("b124","planta baja"));
		System.out.println("Se ha modificado el aula: " + aula);
		
		//se muestra el contenido del mapa, los elementos se muestran
		//por orden de clave
		System.out.println(hashMap);
		
		//se recorren los elementos del mapa y se muestran los valores que almacenan
		for(Integer clave:hashMap.keySet())
			System.out.println(hashMap.get(clave));
		
		//se elimina el elemento con clave 2
		hashMap.remove(2);
		System.out.println(hashMap);
		
		//se eliminan todos los elementos del mapa
		hashMap.clear();
			
	}

}
