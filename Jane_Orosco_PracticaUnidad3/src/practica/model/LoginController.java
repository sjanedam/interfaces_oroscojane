package practica.model;

import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.ESCAPE;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {
	/** CONTROLES Y MÉTODOS DE LA PANTALLA DE LOGIN */
	@FXML
	private Button buttonLogin;

	@FXML
	private TextField userField;

	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Label contra;
	
	@FXML
	private Label usuario;

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
		// Creamos el dialogo de tipo alert
		Alert infoAlert = new Alert(AlertType.ERROR);
		infoAlert.setTitle("Aviso");
		infoAlert.setHeaderText("Se ha produido un error.");
		infoAlert.getDialogPane().setCursor(Cursor.WAIT);
		Stage stage1 = (Stage) infoAlert.getDialogPane().getScene().getWindow();
		stage1.getIcons().add(new Image("img/fail.png"));
		
		stage1.addEventFilter(KeyEvent.KEY_PRESSED, e-> {
			System.out.println(" -> " + e.getCode().toString( ));
			if (e.getCode() == ESCAPE) {
				e.consume();
		    }
		    if (e.getCode() == ENTER) {
		        e.consume();
		    }
		});
		
		String sNombreUsuario = userField.getText().toString();
		String sContrasenya = passwordField.getText().toString();
		
		if (sNombreUsuario.equals("1234") && sContrasenya.toString().equals("1234")) {
			Stage stage = (Stage) buttonLogin.getScene().getWindow();
			stage.close();
			handleButtonLogin();
			
		} else if (passwordField.getText().toString().trim().isEmpty() && userField.getText().trim().isEmpty()) {
			infoAlert.setContentText("La contraseña y el nombre de usuario no pueden estar vacíos, introduzca los datos de nuevo.");
			infoAlert.showAndWait();
			
		} else if (userField.getText().trim().isEmpty()) {
			infoAlert.setContentText("El nombre de usuario no puede estar vacío, introduzca los datos de nuevo.");
			infoAlert.showAndWait();
			
		} else if (passwordField.getText().toString().trim().isEmpty()) {
			infoAlert.setContentText("La contraseña no puede estar vacía, introduzca los datos de nuevo.");
			infoAlert.showAndWait();
			
		} else if (!sNombreUsuario.equals("1234") && !sContrasenya.toString().equals("1234")) {
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));
			contra.setText("La contraseña es incorrecta. Vuelve a intentarlo.");
			contra.setTextFill(Color.rgb(210, 39, 30));
			
		} else if (!sNombreUsuario.equals("1234")) {
			contra.setText("");
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));
			
		} else {
			usuario.setText("");
			contra.setText("La contraseña es incorrecta. Vuelve a intentarlo.");
			contra.setTextFill(Color.rgb(210, 39, 30));
			
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
