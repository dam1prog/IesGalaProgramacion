package edu.combo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase que muestra un ejemplo de uso de un combo, carga de elementos y evento de selección
 * @author Rafa
 * @version 1.0
 */
public class TestCombo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//se crea una lista observable
		ObservableList<String> items = FXCollections.observableArrayList();
		//se añaden elementos de tipo cadena
		items.addAll("item-1", "item-2", "item-3", "item-4", "item-5");
		//se crea un ComboBox cuyos datos son los de la lista anterior
		ComboBox<String> cbx = new ComboBox<>(items);
		//se construye una lista de personas
		ObservableList<Persona> personas = FXCollections.observableArrayList();
		//se añaden personas a la lista
		personas.addAll(new Persona("Félix",20,'H'),new Persona("María",22,'M'));
		//se añade la lista de personas como datos del combo
		ComboBox<Persona> cbPersonas = new ComboBox<>(personas);
		//se crea un contenedor VBox al que se añaden los dos combos
		VBox vbox = new VBox(cbx,cbPersonas);
		//se ajusta el ancho, alto, alineación y espaciado
		vbox.setPrefWidth(Double.MAX_VALUE);
		vbox.setPrefHeight(Double.MAX_VALUE);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(30);
		
		//se suscriben el primer combo al evento, cada vez que se seleccione un elemento del mismo
		//esta vez con ActionListener, por lo que se obitene el origen del evento, el valor anterior
		//y el nuevo valor seleccionado
		cbx.valueProperty().addListener((ov, p1, p2) -> {
		    System.out.println("Actual: " + p2);
		    System.out.println("Anterior: " + p1);
		});
		
		//se suscribe el segundo combo al evento, cada vez que se seleccione un elemento del mismo
		cbPersonas.setOnAction(e -> System.out.println("Has seleccionado " + cbPersonas.getValue()));
		
		Scene scene = new Scene(vbox, 250, 150);
		stage.setTitle("ComboBox JavaFX");
		stage.setScene(scene);
		stage.show();
	}

}
