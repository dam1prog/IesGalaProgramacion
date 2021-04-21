package edu.estilos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestEstilosEtiqueta extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label lbl1 = new Label("Este es un label CSS = .label");
		Label lbl2 = new Label("Este es un label CSS = .label");    
		Label lbl3 = new Label("Este es un label ID = texto, CSS = #texto");
		//se asocia el id #texto para que se aplique el estilo correspondiente
		lbl3.setId("texto");
		
		VBox vbox = new VBox();
		
		//aplicando estilos por código
		vbox.setStyle("-fx-alignment: CENTER; -fx-background-color: gray;");
		
		//se añaden las etiquetas
		vbox.getChildren().addAll(lbl1, lbl2, lbl3);
		
		//se crea la escena
		Scene scene = new Scene(vbox,300,200);
		
		//se aplica desde fichero .css los estilos correspondientes
		//a todos los controles que haya en la escena
		scene.getStylesheets().add(getClass().
				getResource("/estilos.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
	}

}
