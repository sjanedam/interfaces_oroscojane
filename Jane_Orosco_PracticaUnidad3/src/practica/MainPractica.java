package practica;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
public class MainPractica extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/LogInLayout.fxml"));
			AnchorPane logInOverview = (AnchorPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(logInOverview);
			primaryStage.setResizable(true);
			primaryStage.setTitle("Iniciar Sesión");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.getIcons().add(new Image("img/logo.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}