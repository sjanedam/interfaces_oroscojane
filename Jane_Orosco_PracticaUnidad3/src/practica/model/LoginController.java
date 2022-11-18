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

	/* Initialize */
	@FXML
	public void initialize() {
		// Cambiamos el cursor cuando esté dentro del botón de inicio de sesión
		buttonLogin.setCursor(Cursor.HAND);
		// Para poder dar a enter cuando guardemos el usuario y la contraseña
	}
	
	/* Iniciar sesión en la aplicación */
	@FXML
	public void abrirNuevaVentana(ActionEvent event) {		
		// Creamos el dialogo de tipo alert, de tipo error, con su nombre y su header ya que no cambiará a diferencia del contenido
		Alert infoAlert = new Alert(AlertType.ERROR);
		infoAlert.setTitle("Aviso");
		infoAlert.setHeaderText("Se ha produido un error.");
		// Cambiamos el cursor mientras se encuentre dentro del Alert
		infoAlert.getDialogPane().setCursor(Cursor.WAIT);

		// Cambiamos el icono del aviso
		Stage stageAlert = (Stage) infoAlert.getDialogPane().getScene().getWindow();
		stageAlert.getIcons().add(new Image("img/fail.png"));

		// Añadimos un filtro que no nos permitirá salir del Dialogo si pulsamos escape
		// o enter,
		// para salir habrá que pulsar el botón de aceptar
		stageAlert.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			System.out.println(" -> " + e.getCode().toString());
			if (e.getCode() == ESCAPE) {
				e.consume();
			}
			if (e.getCode() == ENTER) {
				e.consume();
			}
		});

		// Recogemos los datos de los Fields usando GetText y transformándolos a String
		String sNombreUsuario = userField.getText().toString();
		String sContrasenya = passwordField.getText().toString();

		// Validamos si la contraseña es correcta, en este caso usamos 1234 y 1234 tanto
		// como usuario como contrseña
		if (sNombreUsuario.equals("1234") && sContrasenya.toString().equals("1234")) {
			// Si la contraseña es correcta, se cierra la ventana en la que nos encontramos
			Stage stage = (Stage) buttonLogin.getScene().getWindow();
			stage.close();

			// Y llamamos al método handleButtonlogin que nos permitirá acceder a la
			// aplicación principal
			handleButtonLogin();

			// Si ambos Fields están vaciós se llamará al Alert y se comunicará un error
		} else if (passwordField.getText().toString().trim().isEmpty() && userField.getText().trim().isEmpty()) {
			infoAlert.setContentText(
					"La contraseña y el nombre de usuario no pueden estar vacíos, introduzca los datos de nuevo.");
			infoAlert.showAndWait();

			// Por el contrario si solo el Field de usuario está vació se llamará al Alert y
			// se cambiará el ContextText informando que el campo de usuario está vació
		} else if (userField.getText().trim().isEmpty()) {
			infoAlert.setContentText("El nombre de usuario no puede estar vacío, introduzca los datos de nuevo.");
			infoAlert.showAndWait();

			// Por el contrario si solo el Field de contraseña está vació se llamará al Alert y
			// se cambiará el ContextText informando que el campo de contraseña está vació
		} else if (passwordField.getText().toString().trim().isEmpty()) {
			infoAlert.setContentText("La contraseña no puede estar vacía, introduzca los datos de nuevo.");
			infoAlert.showAndWait();

			// Si ambos Fields no coinciden con la contraseña, entonces se mostrará un LABEL en
			// color rojo diciendo que no es correcto
		} else if (!sNombreUsuario.equals("1234") && !sContrasenya.toString().equals("1234")) {
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));
			contra.setText("La contraseña es incorrecta. Vuelve a intentarlo.");
			contra.setTextFill(Color.rgb(210, 39, 30));

			// Por el contrario si solo el Field de usuario está erróneo, solo se mostrará
			// el LABEL del usuario
		} else if (!sNombreUsuario.equals("1234")) {
			contra.setText("");
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));

			// Por el contrario si solo el Field de contraseña está erróneo, solo se mostrará
			// el LABEL del contraseña
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
			loginStage.getIcons().add(new Image("img/logo.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
