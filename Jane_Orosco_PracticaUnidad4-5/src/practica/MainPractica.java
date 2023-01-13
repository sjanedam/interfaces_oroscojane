package practica;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
public class MainPractica extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			// ORIGINAL: loader.setLocation(MainPractica.class.getResource("view/MainLayout.fxml"));
			loader.setLocation(MainPractica.class.getResource("view/AppLayout.fxml"));
			BorderPane appOverview = (BorderPane) loader.load();

			// Se añade el diseño y el CSS principal a la escena
			Scene scene = new Scene(appOverview);
			// ORGINAL: scene.getStylesheets().add("practica/view/css/main.css");
			
			primaryStage.setResizable(false);
			primaryStage.setTitle("Gestoría DJO S.L.");
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