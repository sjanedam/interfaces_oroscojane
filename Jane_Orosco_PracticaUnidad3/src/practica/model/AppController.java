package practica.model;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practica.MainPractica;

public class AppController {
	/** CONTROLES Y MÉTODOS DE LA PANTALLA DE APLICACIÓN */
	// TABLA EMPLEADOS
	@FXML
	private TableView<Person> tablaTrabajadores;
	@FXML
	private TableColumn<Person, String> nombreCol;
	@FXML
	private TableColumn<Person, String> dniCol;
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

	// TABLA CITACIONES
	@FXML
	private TableView<Citas> tablaCitas;
	@FXML
	private TableColumn<Citas, String> asuntoCol;
	@FXML
	private TableColumn<Citas, String> fechaCol;

	// FORMULARIO
	// Empleados
	@FXML
	private TextField nombreForm;
	@FXML
	private TextField dniForm;
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

	// Eliminar
	@FXML
	private TextField removeDniForm;

	// Citas
	@FXML
	private DatePicker fechaForm;
	@FXML
	private TextArea asuntoForm;

	// LISTVIEW
	@FXML
	private ListView<String> empresaLista;

	// TREEVIEW
	@FXML
	private TreeView<String> treeEmpresas;

	// Lista auxiliar para tabla de empleados
	private ObservableList<Person> datos = FXCollections.observableArrayList(
			new Person("Ana Ramos", "12345678A", 27, "Mujer", "Notaría", 600909050, "anaramos@mail.com"),
			new Person("Alan Brief", "12345678B", 43, "Hombre", "Seguros", 600900500, "alan@mail.com"),
			new Person("Lola Lolita", "12345678C", 23, "Hombre", "Notaría", 600900500, "lolalolita@mail.com"),
			new Person("Jaime Fuentes", "12345678D", 33, "Hombre", "Abogados", 600900500, "jaimef@mail.com"),
			new Person("María Pérez", "12345678E", 51, "Mujer", "Empresas", 600900500, "mariap@mail.com"),
			new Person("Helena Torres", "12345678F", 43, "Mujer", "Asesoría Laboral", 600900500,
					"helenatorres@mail.com"),
			new Person("Claudia Torres", "12345678G", 37, "Mujer", "Empresas", 600900500, "clautorres@mail.com"));

	// Lista auxiliar para tablas de citas
	private ObservableList<Citas> citaciones = FXCollections.observableArrayList(new Citas("26/10/2022", "Herencia"),
			new Citas("27/10/2022", "Seguro de coche"));

	/* ---------------- MÉTODOS ---------------- */
	/* Inicializar los datos */
	@FXML
	private void initialize() {

		// INFORMACIÓN DE LA TABLA
		tablaTrabajadores.setEditable(true);
		tablaCitas.setEditable(true);

		// Asociamos cada columna del table view a una propiedad de la clase Person y
		// citas
		// Empleados
		nombreCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nombre"));
		dniCol.setCellValueFactory(new PropertyValueFactory<Person, String>("dni"));
		edadCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("edad"));
		sexoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sexo"));
		espCol.setCellValueFactory(new PropertyValueFactory<Person, String>("especializacion"));
		telCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("telefono"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		// Citas
		fechaCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("fecha"));
		asuntoCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("asunto"));

		// Se rellena la tabla con objetos de la clase Person
		tablaTrabajadores.setItems(datos);
		tablaCitas.setItems(citaciones);

		// INFORMACIÓN DE LOS CHOICEBOX
		espChoiceBox.getItems().addAll("Notaría", "Abogados", "Seguros", "Empresas", "Asesoría laboral");
		espChoiceBox.setValue("Selecciona la especialización.");

		// LISTVIEW
		empresaLista.getItems().addAll("Empresa autónoma 1", "Empresa pequeña S. L.", "Empresa grande S. A.",
				"Empresa pequeña S. L. U.", "Empresa autónoma 2", "Empresa autónoma 3");
		empresaLista.setCellFactory(TextFieldListCell.forListView());
		empresaLista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// TREEVIEW
		// RAÍZ
		TreeItem<String> rootItem = new TreeItem<String>("Información de empresas:");

		// Ítem de primer nivel
		TreeItem<String> saItem = new TreeItem<String>("S. A.");
		saItem.getChildren().add(new TreeItem<String>("Empresa grande S. A."));
		rootItem.getChildren().add(saItem);

		// Otro ítem de primer nivel
		TreeItem<String> slItem = new TreeItem<String>("S. L.");
		slItem.getChildren().add(new TreeItem<String>("Empresa pequeña S. L."));
		slItem.getChildren().add(new TreeItem<String>("Empresa pequeña S. L. U."));
		rootItem.getChildren().add(slItem);

		// Otro ítem de primer nivel
		TreeItem<String> auItem = new TreeItem<String>("Autónomos.");
		auItem.getChildren().add(new TreeItem<String>("Empresa autónoma 1"));
		auItem.getChildren().add(new TreeItem<String>("Empresa autónoma 2"));
		auItem.getChildren().add(new TreeItem<String>("Empresa autónoma 3"));
		rootItem.getChildren().add(auItem);

		// Para que sea editable necesitamos especificar un CellFactory con el tipo que
		// corresponda
		treeEmpresas.setCellFactory(TextFieldTreeCell.forTreeView());

		// Expadimos por defecto el ítem raíz
		rootItem.setExpanded(true);
		treeEmpresas.setRoot(rootItem);
	}

	/* Añadir datos a la tabla */
	@FXML
	void addDatos(ActionEvent event) {
		// Permitimos que la tabla pueda ser editado
		tablaTrabajadores.setEditable(true);

		// Añadimos datos a la tabla
		String nombreTrabajador = nombreForm.getText();
		String dniTrabajador = dniForm.getText();
		String edadT = edadForm.getText();
		int edadTrabajador = Integer.parseInt(edadT);

		RadioButton sexoElegido = (RadioButton) sexo.getSelectedToggle();
		String sexoTrabajador = sexoElegido.getText();

		String espTrabajador = espChoiceBox.getValue();
		String telT = telForm.getText();
		int telefonoTrabajador = Integer.parseInt(telT);
		String emailTrabajador = emailForm.getText();

		datos.add(new Person(nombreTrabajador, dniTrabajador, edadTrabajador, sexoTrabajador, espTrabajador,
				telefonoTrabajador, emailTrabajador));

		nombreForm.clear();
		dniForm.clear();
		edadForm.clear();
		telForm.clear();
		emailForm.clear();
		sexo.getSelectedToggle().setSelected(false);
		espChoiceBox.getItems().clear();

		// initialize();

	}

	/* Eliminar datos de la tabla */
	@FXML
	void removeDatos(ActionEvent event) {
		// Permitimos que la tabla pueda ser editado
		tablaTrabajadores.setEditable(true);

		// Recogemos el valor del DNI de la persona que queremos eliminar
		String dniTrabajador = removeDniForm.getText();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Aviso");
		alert.setHeaderText("Esta acción es peligrosa.");
		alert.setContentText("Una vez confirmes esta acción, los datos no podrán ser restaurados.");

		// Icono
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("img/warning.png"));

		Optional<ButtonType> action = alert.showAndWait();
		if (action.get() == ButtonType.OK) {
			// Recorremos la lista
			for (int i = 0; i < datos.size(); i++) {
				if (datos.get(i).getDni().equalsIgnoreCase(dniTrabajador)) {
					datos.remove(i);
				}
			}
			removeDniForm.clear();
		}
	}

	@FXML
	void addDates(ActionEvent event) {
		// Permitimos que la tabla pueda ser editado
		tablaCitas.setEditable(true);

		// Añadimos datos a la tabla
		String fecha = fechaForm.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String asunto = asuntoForm.getText();

		citaciones.add(new Citas(fecha, asunto));

		fechaForm.getEditor().clear();
		asuntoForm.clear();

		initialize();
		// datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	/* Abrir tutorial */
	@FXML
	void abrirTutorial(ActionEvent event) {
		Stage tutorialStage = new Stage();
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/TutorialLayout.fxml"));
			BorderPane tutorialOverview = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(tutorialOverview);
			tutorialStage.setResizable(false);
			tutorialStage.setTitle("PRÁCTICA UNIDAD 1-2. GESTORÍA.");
			tutorialStage.setScene(scene);
			tutorialStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
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

	/* Logout */
	private void handleButtonLogout() {
		Stage primaryStage = new Stage();
		try {
			// Cargamos el FXML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("view/LogInLayout.fxml"));
			AnchorPane logInOverview = (AnchorPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(logInOverview);
			primaryStage.setResizable(false);
			primaryStage.setTitle("PRÁCTICA UNIDAD 1-2. GESTORÍA.");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
