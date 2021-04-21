package edu.preloader;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader.StateChangeNotification;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestPreloader extends Application {
	private BooleanProperty ready = new SimpleBooleanProperty(false);
	
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// simular carga
		longStart();

		Label label = new Label("JavaFX Medusa Preloader");
		StackPane pane = new StackPane(label);
		stage.setTitle("Tutor de Programacion");
		stage.setScene(new Scene(pane, 400, 400));

		// Abrir el stage principal cuando la carga este al 100%
		ready.addListener((ov, t, t1) -> {
			if (Boolean.TRUE.equals(t1)) {
				Platform.runLater(() -> {
					stage.show();
				});
			}
		});
	}

	@Override
	public void init() throws Exception {
		Thread.sleep(2500);
	}
	
	private void longStart() {
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int max = 100;
                // enviar notidicacion de progreso cada 50 ms
                /*for (int i = 1; i <= max; i++) {
                    Thread.sleep(50);
                    notifyPreloader(new ProgressNotification(i));
                }*/

                Thread.sleep(2000);
                // indicar que la carga ha terminado, 100% completa
                ready.setValue(Boolean.TRUE);
                notifyPreloader(new StateChangeNotification(StateChangeNotification.Type.BEFORE_START));

                return null;
            }
        };
        new Thread(task).start();
    }
}
