package practica.model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	/** CONTROLES Y MÉTODOS DE LA PANTALLA DE LOGIN */
	@FXML
	private Button buttonLogin;

	@FXML
	private TextField userField;

	@FXML
	private PasswordField passwordField;

	/* ---------------- MÉTODOS ---------------- */
	/* Salir de la aplicación */
	@FXML
	private void exitApp(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	public void initialize() {
		// Cambiar el cursor
		buttonLogin.setCursor(Cursor.HAND);
	}

	/* Iniciar sesión en la aplicación */
	@FXML
	private void abrirNuevaVentana(ActionEvent event) {
		String sNombreUsuario = userField.getText().toString();
		String sContrasenya = passwordField.getText().toString();
		if (sNombreUsuario.equals("1234") && sContrasenya.toString().equals("1234")) {
			Stage stage = (Stage) buttonLogin.getScene().getWindow();
			stage.close();
			handleButtonLogin();
			
		} else {
			Alert infoAlert = new Alert(AlertType.ERROR);
			infoAlert.setTitle("Aviso");
			infoAlert.setHeaderText("Se ha produido un error.");
			infoAlert.setContentText("El nombre de usuario o la contraseña no son correctas, introduzca los datos de nuevo.");
			infoAlert.showAndWait();
		}
	}
	private void handleButtonLogin() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/AppLayout.fxml"));
			Stage loginStage = new Stage();
			loginStage.setTitle("Aplicación");
			loginStage.setScene(new Scene(root));
			loginStage.show();
			loginStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
