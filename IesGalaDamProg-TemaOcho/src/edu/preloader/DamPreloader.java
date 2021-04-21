package edu.preloader;

import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DamPreloader extends Preloader {
	private Stage stage;
	/**
	 * Crea la escena del cargador
	 * @return Devuelve la escena creada con todos los controles JavaFx
	 */
	private Scene createPreloaderScene() {
		String url = getClass().getResource("/preloader.png").toExternalForm();

		//se crea un contenedor de imagen con la imagen del loader
		ImageView progress = new ImageView(url);
		//se crean etiques con estilos css
		Label title = new Label("1º DAM Programación JavaFx");
		title.setStyle("-fx-font-size: 2.3em; -fx-text-fill: whitesmoke;");

		Label footer = new Label("IES Antonio Gala");
		footer.setStyle("-fx-font-size: 0.95em; -fx-text-fill: whitesmoke; -fx-font-style: oblique;");
		//se crea un admin. diseño vertical
		VBox root = new VBox();
		//se asigna un espaciado de 10 píxels
		root.setSpacing(10.0);
		//se asigna la alineación centrada en los controles del VBox
		root.setAlignment(Pos.CENTER); 
		//se añaden al VBox las etiquetas
		root.getChildren().addAll(title, progress);

		//se crea un nuevo administrador de diseño de tipo norte,sur,...
		//que se coloca dentro del VBox, a continuación las etiquetas
		BorderPane pane = new BorderPane(root);
		//se añade la etiqueta footer al pie del admin. anterior
		pane.setBottom(footer);
		//se asigna un estilo css al BorderPane
		pane.setStyle("-fx-background-color: #2b579a;");
		//se devuelve el objeto de tipo escena incluyendo todo lo anterior
		return new Scene(pane, 480, 320, Color.TRANSPARENT);
	}
	@Override
	public void start(Stage stage) throws Exception {		
		this.stage = stage;
		//se personaliza el aspecto de la ventana antes de mostrarla
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(createPreloaderScene());
		stage.show();
	}

	/**
	 * Método de evento para notificaciones de cambio de estado en la ventana
	 */
	@Override
	public void handleStateChangeNotification(StateChangeNotification scn) {
		if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
			stage.hide();
		}
	}
}
