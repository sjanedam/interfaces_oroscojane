package practica.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	private TableColumn<Person, Integer> edadCol;
	@FXML
	private TableColumn<Person, String> sexoCol;
	@FXML
	private TableColumn<Person, String> espCol;
	@FXML
	private TableColumn<Person, Integer> telCol;
	@FXML
	private TableColumn<Person, String> emailCol;
	
	/* FORMULARIO */
    @FXML
    private TextField nombreForm;
	@FXML
    private TextField apellidoForm;
    @FXML
    private TextField edadForm;
    @FXML
    ToggleGroup sexo;
    @FXML
    private ChoiceBox<String> espChoiceBox;
    @FXML
    private TextField telForm;
    @FXML
    private TextField emailForm;

	/* Lista auxiliar para Tablas */
	private ObservableList<Person> datos = FXCollections.observableArrayList(
			new Person("Ana","Ramos",27,"Mujer","Seguros",600909050,"anaramos@mail.com"),
			new Person("Alan","Brief",43,"Hombre","Gestor",600900500,"alan@mail.com")
	);

	/* ---------------- MÉTODOS ---------------- */
	@FXML
	private void initialize() {
		/** INFORMACIÓN DE LA TABLA */
		tablaTrabajadores.setEditable(true);
		/* Asociamos cada columna del table view a una propiedad de la clase Person */
		nombreCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nombre"));
		apellidoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("apellido"));
		edadCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("edad"));
		
		sexoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sexo"));
		espCol.setCellValueFactory(new PropertyValueFactory<Person, String>("especializacion"));
		telCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("telefono"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		// Se rellena la tabla con objetos de la clase Person
		tablaTrabajadores.setItems(datos);
		
		/** INFORMACIÓN DE LOS CHOICEBOX */
		espChoiceBox.getItems().addAll("Seguros","Gestor","Empresas","Herencias","Comunidades");
		espChoiceBox.setValue("Selecciona la especialización.");
	}
	
	@FXML
    void addDatos(ActionEvent event) {
		tablaTrabajadores.setEditable(true);
		
		/** AÑADIMOS DATOS A LA TABLA */
		String nombreTrabajador = nombreForm.getText();
		String apellidoTrabajador = apellidoForm.getText();
		String edadT = edadForm.getText();
		int edadTrabajador = Integer.parseInt(edadT);

		RadioButton sexoElegido = (RadioButton) sexo.getSelectedToggle();
		String sexoTrabajador = sexoElegido.getText();
		
		String espTrabajador = espChoiceBox.getValue();
		String telT = telForm.getText();
		int telefonoTrabajador = Integer.parseInt(telT);
		String emailTrabajador = emailForm.getText();
		
		datos.add(new Person(nombreTrabajador, apellidoTrabajador,edadTrabajador,
				sexoTrabajador, espTrabajador, telefonoTrabajador, emailTrabajador));
		
		nombreForm.clear();
		apellidoForm.clear();
		edadForm.clear();
		telForm.clear();
		emailForm.clear();
		
		initialize();
		
    }
	
	/* Cerrar la aplicación */
	@FXML
	private void exitApp(ActionEvent event) {
		System.exit(0);
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
