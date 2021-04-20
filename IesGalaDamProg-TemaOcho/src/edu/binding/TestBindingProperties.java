package edu.binding;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase de ejemplo en la que se enlazan propiedades de controles JavaFx
 * @author Rafa
 * @version 1.0
 *
 */
public class TestBindingProperties extends Application {
	private Stage primaryStage;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		AnchorPane root = FXMLLoader.load(getClass().getResource("/BindingProperties.fxml"));

		Scene scene = new Scene(root);

		//se obtiene la referencia al slider
		Slider slider = (Slider)scene.lookup("#sdProgress");
		//se obtiene la referencia al ProgressBar
		ProgressBar progressBar = (ProgressBar)scene.lookup("#pbProgress");

		//se enlazan (unidireccional) las propiedades del Slider y del ProgressBar
		if(slider!=null && progressBar!=null)
			progressBar.progressProperty().bind(slider.valueProperty());

		//se obtiene la referencia a la lista
		ListView lvDatos = (ListView)scene.lookup("#lvDatos");
		//se añaden valores a la lista
		lvDatos.getItems().addAll(1, 2, 3, 4, 5);

		Label lblSeleccionado = (Label)scene.lookup("#lblSeleccionado");
		//se enlaza la propiedad que obitiene el elemento seleccionado de la lista
		//con la propiedad que asigna el valor de texto a la etiqueta
		lblSeleccionado.textProperty().bind(lvDatos.getSelectionModel()
				.selectedItemProperty().asString("Elemento seleccionado: %d"));
		
		//se obtienen las referencia a las cajas de texto
		TextField tfEcho1 = (TextField)scene.lookup("#tfEcho1");
		TextField tfEcho2 = (TextField)scene.lookup("#tfEcho2");
		//se crea un enlace bidireccional entre las dos cajas de texto.
		tfEcho1.textProperty().bindBidirectional(tfEcho2.textProperty());

		//se obtiene la referencia al slider del conversor
		Slider sdConversor = (Slider)scene.lookup("#sdConversor");
		//se muestran las marcas y las etiquetas de valores
		sdConversor.setShowTickMarks(true);
		sdConversor.setShowTickLabels(true);
		//se obtienen las referencias a las etiquetas para mostrar los metros y pulgadas equivalentes 
		Label lblMetros = (Label)scene.lookup("#lblMetros");
		Label lblPulgadas = (Label)scene.lookup("#lblPulgadas");
		//se enlaza la etiqueta con el valor de los metros con el progreso del slider
		lblMetros.textProperty().bind(sdConversor.valueProperty().asString("Metros %.2f"));
		//se aplica una operacion de multiplicación sobre el valor del slider
		NumberBinding pulgadas = sdConversor.valueProperty().multiply(39.3701);
		//se enlaza la propiedadad de valor calculada según la conversión de metros a pulgadas.
		lblPulgadas.textProperty().bind(pulgadas.asString("En pulgadas: %.2f"));
		
		//se obtiene la referencia al checkbox
		CheckBox chbActivar = (CheckBox)scene.lookup("#chbActivar");
		//se obtiene la referencia al contenedor VBox principal
		VBox vbPrincipal = (VBox)scene.lookup("#vbPrincipal");
		//se enlaza la propiedad que habilita el contenedor principal con la propiedad que selecciona o no
		//el checkbox
		vbPrincipal.disableProperty().bind(chbActivar.selectedProperty());
				
		
		this.primaryStage.setTitle("Binding de propiedades de controles JavaFx");
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}

}
