package practica.model;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import practica.MainPractica;

public class Controller {
	@FXML
	private Button buttonLogin;

	@FXML
	private TextField userField;

	@FXML
	private PasswordField passwordField;
	

	@FXML
	private MenuItem cerrarSesion;

    @FXML
    private Label prueba;


	// MÉTODOS
	@FXML
	private void exitApp(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void abrirNuevaVentana(ActionEvent event) {
		String sNombreUsuario = userField.getText().toString();
		String sContrasenya = passwordField.getText().toString();
		if (sNombreUsuario.equals("1234") && sContrasenya.toString().equals("1234")) {
			Stage stage = (Stage) buttonLogin.getScene().getWindow();
			stage.close();
			handleButtonClick();
		} else {
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("Aviso");
			ButtonType button = new ButtonType("De acuerdo.", ButtonData.OK_DONE);
			dialog.setContentText("El nombre de usuario y la contraseña no son correctas, introduzca los datos de nuevo.");
			dialog.getDialogPane().getButtonTypes().add(button);
			dialog.showAndWait();
		}
	}

	private void handleButtonClick() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/AppLayout.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Aplicación");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void cerrarSesion(ActionEvent event) {
		Stage stage = (Stage) prueba.getScene().getWindow();
		stage.close();
		handleMenuItem();
	}

	private void handleMenuItem() {
		Stage primaryStage = new Stage();
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/LogInLayout.fxml"));
			AnchorPane logInOverview = (AnchorPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(logInOverview);
			primaryStage.setResizable(true);
			primaryStage.setTitle("PRÁCTICA UNIDAD 1-2. GESTORÍA.");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
