package practica.model;

import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	
	@FXML
	private ImageView exit;
	
	@FXML
	private ImageView back;
	
	// Listener para el campo de texto y la contraseña
		ChangeListener<Object> listener = new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {
				System.out.println("Estado antiguo: " + arg1 + ", estado nuevo: " + arg2);
				if (arg2 != "") {
					buttonLogin.setDisable(false);
				} 
				if (arg2 == "") {
					buttonLogin.setDisable(true);
				}
			}
			
		};
	

	/* ---------------- MÉTODOS ---------------- */
	/** Salir de la aplicación */
	@FXML
	private void exitApp(MouseEvent event) {
		System.exit(0);
	}
	
	/** Volver atrás */
	@FXML
	private void goBack(MouseEvent event) {
		Stage appStage = (Stage) exit.getScene().getWindow();
		appStage.close();
		
		Parent root;
		
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/MainLayout.fxml"));
			Stage loginStage = new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add("practica/view/css/main.css");
			loginStage.setTitle("Gestoría DJO S.L.");
			loginStage.setScene(scene);
			loginStage.show();
			loginStage.setResizable(false);
			loginStage.getIcons().add(new Image("img/home.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Initialize */
	@FXML
	public void initialize() {
		// Cambiamos el cursor cuando esté dentro del botón de inicio de sesión
		buttonLogin.setDisable(true);
		buttonLogin.setCursor(Cursor.HAND);
		exit.setCursor(Cursor.HAND);
		back.setCursor(Cursor.HAND);
		
		userField.textProperty().addListener(listener);
		passwordField.textProperty().addListener(listener);
	}
	
	/** Iniciar sesión en la aplicación */
	@FXML
	public void abrirNuevaVentana(ActionEvent event) {	
		// Recogemos los datos de los Fields usando GetText y transformándolos a String
		String sNombreUsuario = userField.getText().toString();
		String sContrasenya = passwordField.getText().toString();

		// Validamos si la contraseña es correcta, en este caso usamos 1234 y 1234 tanto como usuario como contraseña
		if (sNombreUsuario.equals("1234") && sContrasenya.toString().equals("1234")) {
			// Si la contraseña es correcta, se cierra la ventana en la que nos encontramos
			Stage stage = (Stage) buttonLogin.getScene().getWindow();
			stage.close();

			// Y llamamos al método handleButtonlogin que nos permitirá acceder a la aplicación principal
			handleButtonLogin();
			
			// Si ambos Fields no coinciden con la contraseña, entonces se mostrará un LABEL en color rojo diciendo que no es correcto
		} else if (!sNombreUsuario.equals("1234") && !sContrasenya.toString().equals("1234")) {
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));
			contra.setText("La contraseña es incorrecta. Vuelve a intentarlo.");
			contra.setTextFill(Color.rgb(210, 39, 30));
			

			// Por el contrario si solo el Field de usuario está erróneo, solo se mostrará el LABEL del usuario
		} else if (!sNombreUsuario.equals("1234")) {
			contra.setText("");
			usuario.setText("El nombre de usuario es incorrecto. Vuelve a intentarlo.");
			usuario.setTextFill(Color.rgb(210, 39, 30));

			// Por el contrario si solo el Field de contraseña está erróneo, solo se mostrará el LABEL del contraseña
		} else {
			usuario.setText("");
			contra.setText("La contraseña es incorrecta. Vuelve a intentarlo.");
			contra.setTextFill(Color.rgb(210, 39, 30));
		}
	}

	/** Método para abrir la nueva ventana de inicio de sesión */
	private void handleButtonLogin() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/AppLayout.fxml"));
			Stage loginStage = new Stage();
			loginStage.setTitle("Gestoría DJO S.L. Aplicación.");
			loginStage.setScene(new Scene(root));
			loginStage.show();
			loginStage.setResizable(false);
			loginStage.getIcons().add(new Image("img/logo.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
