package edu.eventos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Clase para probar la asociación de eventos en código a componentes de un formulario FXML
 * @author Rafa
 * @version 1.0
 */
public class TestEventos extends Application{
	private Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		AnchorPane root = FXMLLoader.load(getClass().getResource("/EventoEntrada.fxml"));

		Scene scene = new Scene(root, 300, 275);
		//se obtiene la referencia al primer botón
		Button boton1 = (Button)scene.lookup("#boton1");
		//se crea el método de evento del manejador para el primer botón
		EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("handler1...");
				if(event.getButton()==MouseButton.SECONDARY)
					System.out.println("Has pulsado el botón derecho del ratón");
				else
					System.out.println("Has pulsado el botón izquierdo del ratón");
			}
		};

		boton1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
		//se obtiene la referencia al segundo botón
		Button boton2 = (Button)scene.lookup("#boton2");
		//se crea el método de evento del manejador para el segundo botón
		EventHandler<MouseEvent> handler2 = (MouseEvent event) -> {
			System.out.println("handler2...");
		};

		boton2.addEventHandler(MouseEvent.MOUSE_CLICKED, handler2);

		//se obtiene las referencia a los componentes del formulario que permiten
		//la entrada de texto desde teclado
		TextField tfNombre = (TextField)scene.lookup("#tfNombre");
		TextArea tfApellidos =  (TextArea)scene.lookup("#tfApellidos");
		PasswordField tfClave = (PasswordField)scene.lookup("#pfClave");

		scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
			//se obtiene el nombre del evento
			String type = e.getEventType().getName();
			//se obtiene el origen del evento
			String source = e.getSource().getClass().getSimpleName();
			//se obtiene el objeto de evento
			String target = e.getTarget().getClass().getSimpleName();

			System.out.println("Evento: " + type + ", " + source + ", " + target);
			//se controla que no se introduzcan números en los componentes de la escena
			//que permiten la entrada de teclado
			if (Character.isDigit(e.getCharacter().charAt(0))) {
				System.out.println("caracter: " + e.getCharacter() + ", no permitido.");
				e.consume();
			}else {
				System.out.println("Has pulsado " + e.getCharacter());
			}
		});

		this.primaryStage.setTitle("Asociar eventos");
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}
}
