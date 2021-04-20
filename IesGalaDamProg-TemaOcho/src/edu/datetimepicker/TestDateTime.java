package edu.datetimepicker;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestDateTime extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		DatePicker fecha1 = new DatePicker();

		DatePicker fecha2 = new DatePicker(LocalDate.now());
		fecha2.setEditable(false);
		fecha2.setPrefWidth(Double.MAX_VALUE);
		
		VBox vbox = new VBox(fecha1,fecha2);
		vbox.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(30);
		
		Scene scene = new Scene(vbox,300,200);
		
		stage.setScene(scene);
		stage.show();
	}

}
