package edu.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class TestXmlLibros {
	private Document doc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Pasa la información de un XML a un DOM
	 * @param fichero Fichero de datos XML
	 * @return Devuelve 0 si no se produce error, en caso contrario -1
	 */
	public int convertirXmlDom(File fichero){

		doc = null; // doc es de tipo Document y representa al árbol DOM

		try{
			// Se crea un objeto DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML
			factory.setIgnoringComments(true);

			// Ignora los espacios en blanco que tenga el documento
			factory.setIgnoringElementContentWhitespace(true);

			// Se crea un objeto DocumentBuilder para cargar en él la estructura del árbol DOM a partir del XML seleccionado
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Interpreta (parsea) el documento XML (file) y genera el DOM equivalente
			doc = builder.parse(fichero);

			// Ahora doc apunta al árbol DOM listo para ser recorrido

			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}

	}
	/**
	 * Recorre el DOM y muestra su contenido, los datos de todos los libros
	 * @param doc Raíz del dom
	 * @return Cadena con formato y con los datos de todos los libros contenidos en el DOM
	 */
	public String recorrerDOMyMostrar(Document doc){

		String datos_nodo[] = null;
		String salida = "";
		Node node;

		// Obtiene el primer nodo del DOM (primer hijo)
		Node raiz = doc.getFirstChild();

		// Obtiene una lsita de nodos con todos los nodos hijo del raíz
		NodeList nodeList = raiz.getChildNodes();

		// Procesa los nodos hijo
		for (int i = 0; i < nodeList.getLength(); i++){
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				// Es un nodo libro
				datos_nodo = procesarLibro(node);
				salida = salida + "\n " + "Publicado en: " + datos_nodo[0];
				salida = salida + "\n " + "El autor es: " + datos_nodo[2];
				salida = salida + "\n " + "El título es: " + datos_nodo[1];
				salida = salida + "\n --------------------";
			}
		}
		return salida;
	}
	/**
	 * Pasa los datos de un libro de un Node a un un array de tipo String
	 * @param n Nodo que contiene los datos de un libro
	 * @return Array de tipo String con con los datos de un libro
	 */
	private String[] procesarLibro(Node n){
		String datos[] = new String[3];
		Node ntemp = null;
		int contador = 1;

		// Obtiene el valor del primer atributo del nodo (solo uno en este ejemplo)
		datos[0] = n.getAttributes().item(0).getNodeValue();

		// Obtiene los hijos del Libro (título y autor)
		NodeList nodos = n.getChildNodes();
		for (int i = 0; i <nodos.getLength(); i++){
			ntemp = nodos.item(i);
			if(ntemp.getNodeType() == Node.ELEMENT_NODE){
				/* Importante: para obtener el texto con el título y 
				 * autor se accede al nodo TEXT hijo de ntemp y se saca su valor */
				datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
				contador++;
			}
		}
		return datos;
	}
	/**
	 * Añade un nuevo elemento al DOM
	 * @param doc Raíz del DOM del fichero XML
	 * @param titulo Título del libro
	 * @param autor Autor del libro
	 * @param anno Año de publicación
	 * @return Devuelve 0 si se consigue añadir el libro, en caso contrario -1
	 */
	public int annadirDOM(Document doc, String titulo, String autor, String anno){

		try{
			// Se crea un nodo tipo Element con nombre 'titulo' (<Titulo>)
			Node ntitulo = doc.createElement("Titulo");

			// Se crea un nodo tipo texto con el títlo del libro
			Node ntitulo_text = doc.createTextNode(titulo);

			// Se añade el nodo de texto con el título como hijo del elemento Titulo
			ntitulo.appendChild(ntitulo_text);

			// Se hace lo mismo que con titulo a autor (<Autor>)
			Node nautor = doc.createElement("Autor");
			Node nautor_text = doc.createTextNode(autor);
			nautor.appendChild(nautor_text);

			// Se crea un nodo de tipo elemento (<libro>)
			Node nlibro = doc.createElement("Libro");

			//  Al nuevo nodo libro se le añade un atributo publicado_en
			((Element)nlibro).setAttribute("publicado_en", anno);

			// Se añade a libro el nodo autor y titulo creados antes
			nlibro.appendChild(ntitulo);
			nlibro.appendChild(nautor);

			/* Finalmente, se obtiene el primer nodo del documento y a él se le
	          añade como hijo el nodo libro que ya tiene colgando todos sus
	          hijos y atributos creados antes. */
			Node raiz = doc.getChildNodes().item(0);
			raiz.appendChild(nlibro);

			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * Serializa y guarda un DOM en un fichero XML
	 * @return Devuelve 0 si todo va bien, -1 en caso de error
	 */
	public int guardarDOMcomoFILE(){
		DOMImplementationRegistry domRegistry = null;
		try {
			domRegistry = DOMImplementationRegistry.newInstance();

			DOMImplementationLS impl = (DOMImplementationLS) domRegistry
					.getDOMImplementation("LS");

			LSSerializer writer = impl.createLSSerializer();

			writer.getDomConfig().setParameter("xml-declaration", false);
			writer.getDomConfig().setParameter("format-pretty-print", true);

			LSOutput output = impl.createLSOutput();
			output.setEncoding("UTF-8");

			File archivoXml = new File("salida.xml");

			output.setByteStream(new FileOutputStream(archivoXml));
			writer.write(doc, output);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int nuevoDomFile() {

		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document doc = implementation.createDocument(null, "Libros", null);
			doc.setXmlVersion("1.0");
			this.annadirDOM(doc,"Desarrollo de Interfaces", "Pablo Martinez", "2010");
			this.annadirDOM(doc,"Acceso a datos", "Alberto Carrera", "2011");
			this.annadirDOM(doc,"Formación y orientación laboral", "Belén Carrera", "2012");

			/* A partir de aquí cambio respecto a la versión anterior.
              Lo podría haber puesto como segundo método de guardar de ObjetoDOM y llamarlo */
			Source source = new DOMSource(doc);
			Result result = new StreamResult(new java.io.File("profesores.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
}
