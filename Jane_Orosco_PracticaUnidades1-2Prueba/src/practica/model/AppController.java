package practica.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import practica.MainPractica;

public class AppController {
	/** CONTROLES Y MÉTODOS DE LA PANTALLA DE APLICACIÓN */
	/* TABLA */
	@FXML
	private TableView<Person> tablaTrabajadores;
	@FXML
	private TableColumn<Person, String> nombreCol;
	@FXML
	private TableColumn<Person, String> apellidoCol;
	@FXML
	private TableColumn<Person, String> emailCol;
	
	/* FORMULARIO */
    @FXML
    private TextField nombreForm;
	@FXML
    private TextField apellidoForm;
    @FXML
    private TextField emailForm;
    @FXML
    private TextField edadForm;

	@FXML
	private TableColumn<Person, Integer> edadCol;

	/* Lista auxiliar para Tablas */
	private ObservableList<Person> datos = FXCollections.observableArrayList(
			new Person("Jacob", "Smith", "jacob.smith@example.com", 30),
			new Person("Isabella", "Johnson", "isabella.johnson@example.com", 40),
			new Person("Ethan", "Williams", "ethan.williams@example.com", 50),
			new Person("Emma", "Jones", "emma.jones@example.com", 61),
			new Person("Michael", "Brown", "michael.brown@example.com", 34));

	/* ---------------- MÉTODOS ---------------- */
	@FXML
	private void initialize() {
		tablaTrabajadores.setEditable(true);
		/* Asociamos cada columna del table view a una propiedad de la clase Person */
		nombreCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nombre"));
		apellidoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("apellido"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		edadCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("edad"));
		// Se rellena la tabla con objetos de la clase Person
		tablaTrabajadores.setItems(datos);
	}
	
	/* Cerrar sesión de la aplicación y que vuelva a la pantalla de login */
	@FXML
	private void cerrarSesion(ActionEvent event) {
		Stage stage = (Stage) tablaTrabajadores.getScene().getWindow();
		stage.close();
		handleButtonLogout();
	}

	private void handleButtonLogout() {
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
