package edu.estilos.boton;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * Clase para probar estilos en botones JavaFX
 * @author Rafa
 * @version 1.0
 */
public class TestEstilosBoton extends Application{
	private HBox panelBotones;
	private Scene scene;
	private StackPane root;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.root = new StackPane();
		this.scene = new Scene(root, 300, 250);

		this.panelBotones = new HBox();

		this.loadButtons("Estilo 1", "boton1", "estilo1.css");
		this.loadButtons("Estilo 2", "boton2", "estilo2.css");
		this.loadButtons("Sin estilo", "boton3", "");

		// Organizar los elementos en la ventana
		panelBotones.setSpacing(20);
		panelBotones.setAlignment(Pos.CENTER);
		root.getChildren().add(panelBotones);

		primaryStage.setTitle("Ejemplo de uso de CSS en JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void loadButtons(String text, String buttonId, String style) {
		Button button = new Button();
		button.setText(text);
		// Asignar un identificador para la hoja de estilos
		button.setId(buttonId); 
		button.setOnAction(new EventHandler() {            
			@Override
			public void handle(Event event) {
				// Limpiar los estilos que tuviera anteriormente
				scene.getStylesheets().clear();
				if(style.length()>0)
					// Aplicar la hoja de estilos
					scene.getStylesheets().add(
							getClass().getResource("/" + style).toExternalForm());                 
			}
		});
		this.panelBotones.getChildren().add(button);
	}
}
