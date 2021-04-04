package edu.xml;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestXml {

	public static void main(String[] args) {
		int i=0, j=0;
		boolean result=false;
		Optional<Document> document = getDOM("dataset.xml");

		System.out.println(document.get().getNodeName());
		System.out.println(document.get().getInputEncoding());
		System.out.println(document.get().getXmlVersion());
		System.out.println(document.get().getFirstChild().getNodeName());

		Element raiz=document.get().getDocumentElement();
		System.out.println(document.get().getDocumentElement().getNodeName());

		NodeList listaNodos=document.get().getElementsByTagName("record");
		while(i<listaNodos.getLength() && !result) {
			Node node = listaNodos.item(i);
			NodeList childList = node.getChildNodes();
			while(j<childList.getLength() && !result) {
				Node childNode = childList.item(j);
				if(childNode.getNodeName().equals("first_name")
						&& node.getNodeValue().equals("Maribelle")){
					result=true;
				}
				j++;
			}
			i++;
		}

	}

	public static Optional<Document> getDOM(String filePath) {
		try {
			// 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			// 2º A partir de la instancia anterior, fabricamos un constructor de documentos, 
			// que procesará el XML.
			DocumentBuilder db = dbf.newDocumentBuilder();

			// 3º Procesamos el documento (almacenado en un archivo) y lo 
			//convertimos en un árbol DOM.
			Optional<Document> documento=Optional.of(db.parse(filePath));

			//devolvemos el Optional del DOM
			return documento;

		} catch (Exception ex) {
			System.out.println("¡Error! No se ha podido cargar el documento XML.");
			return Optional.empty();
		} 
	}

}
