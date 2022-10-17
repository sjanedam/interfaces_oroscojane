package practica;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainPractica extends Application {
	// ESCENAS
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PRÁCTICA U1-U2: GESTORÍA");
		showMain();
		showLogInOverview();
	}

	/** Inicializamos el diseño de la pantalla principal */
	public void showMain() {
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/MainLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Mostramos el diseño de Log In dentro de la pantalla principal Main */
	public void showLogInOverview() {
		try {
			// Cargamos el archivo App
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/LogInLayout.fxml"));
			AnchorPane logInOverview = (AnchorPane) loader.load();
			// Lo situamos en el centro del diseño principal
			rootLayout.setCenter(logInOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/** Getter, return the main stage */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
