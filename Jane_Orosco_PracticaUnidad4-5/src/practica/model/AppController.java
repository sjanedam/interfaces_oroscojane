package practica.model;

import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.ESCAPE;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practica.MainPractica;

/**
 * Controlador de la aplicación para el mantenimiento de las tablas
 * @author Jane Orosco
 * 
 */
public class AppController {
	/* INICIALIZAMOS LAR VARIABLES @FXML */
		/*---------------- PESTAÑA EMPLEADOS ----------------*/
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
		
		// FORMULARIO DE EMPLEADOS (AÑADIR DATOS A LA TABLA)
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
		
		// FORMULARIOS DE EMPLEADOS (ELIMINAR DATOS DE LA TABLA)
			@FXML
			private TextField removeDniForm;

		/*---------------- PESTAÑA CITACIONES ----------------*/
		// TABLA CITACIONES
			@FXML
			private TableView<Citas> tablaCitas;
			@FXML
			private TableColumn<Citas, String> asuntoCol;
			@FXML
			private TableColumn<Citas, String> horaCol;
			@FXML
			private TableColumn<Citas, String> fechaCol;
			@FXML
			private TableColumn<Citas, String> prioridadCol;
	
		// FORMULARIOS CITACIONES
			@FXML
			private DatePicker fechaForm;
			@FXML
			private TextField horaForm;
			@FXML
			private TextArea asuntoForm;
			@FXML
			private ComboBox<String> prioComboBox;

	/*---------------- LISTVIEW ----------------*/
	@FXML
	private ListView<String> empresaLista;

	/*---------------- TREEVIEW ----------------*/
	@FXML
	private TreeView<String> treeEmpresas;

	/*---------------- Lista auxiliar para tabla de empleados ----------------*/
	private ObservableList<Person> datos = FXCollections.observableArrayList(
			new Person("Ana Ramos", "12345678A", 27, "Mujer", "Notaría", 600909050, "anaramos@mail.com"),
			new Person("Alan Brief", "12345678B", 43, "Hombre", "Seguros", 600900500, "alan@mail.com"),
			new Person("Lola Lolita", "12345678C", 23, "Hombre", "Notaría", 600900500, "lolalolita@mail.com"),
			new Person("Jaime Fuentes", "12345678D", 33, "Hombre", "Abogados", 600900500, "jaimef@mail.com"),
			new Person("María Pérez", "12345678E", 51, "Mujer", "Empresas", 600900500, "mariap@mail.com"),
			new Person("Helena Torres", "12345678F", 43, "Mujer", "Asesoría Laboral", 600900500, "helenatorres@mail.com"),
			new Person("Claudia Torres", "12345678G", 37, "Mujer", "Empresas", 600900500, "clautorres@mail.com"));

	/*---------------- Lista auxiliar para tablas de citas ----------------*/
	private ObservableList<Citas> citaciones = FXCollections.observableArrayList(
			new Citas("26/10/2022", "10:30AM", "Herencia", "Alta"),
			new Citas("27/10/2022", "11:00AM", "Seguro de coche", "Baja"),
			new Citas("27/10/2022", "12:00PM", "Herencia", "Media"));

	/* ---------------- MÉTODOS ---------------- */
	/**
	 * MÉTODO EN EL QUE SE INICIALIZAN LOS DATOS
	 * 
	 */
	@FXML
	private void initialize() {
		/* ---------------- TABLA EMPLEADOS ---------------- */
		tablaTrabajadores.setEditable(true);
			
		// Asociamos cada columna del table view a una propiedad de la clase Person
			nombreCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nombre"));
			dniCol.setCellValueFactory(new PropertyValueFactory<Person, String>("dni"));
			edadCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("edad"));
			sexoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sexo"));
			espCol.setCellValueFactory(new PropertyValueFactory<Person, String>("especializacion"));
			telCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("telefono"));
			emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		
		// Se rellena la tabla con objetos de la clase Person
			tablaTrabajadores.setItems(datos);
		
			
		/* ---------------- TABLA CITACIONES ---------------- */
		tablaCitas.setEditable(true);
		
		// Asociamos cada columna del table view a una propiedad de la clase Citas
			fechaCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("fecha"));
			horaCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("hora"));
			asuntoCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("asunto"));
			prioridadCol.setCellValueFactory(new PropertyValueFactory<Citas, String>("prioridad"));

		// Se rellena la tabla con objetos de la clase Citas
		tablaCitas.setItems(citaciones);

		
		/* ---------------- INFORMACIÓN DE LOS CHOICE BOX ---------------- */
		espChoiceBox.getItems().addAll("Notaría", "Abogados", "Seguros", "Empresas", "Asesoría laboral");
		espChoiceBox.setValue("Selecciona la especialización.");
		
			// Listener
		espChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
		});

		/* ---------------- INFORMACIÓN DEL COMBO BOX ---------------- */
		prioComboBox.getItems().addAll("Baja", "Alta", "Media", "Urgente");
		prioComboBox.setValue("Prioridad...");
			// Listener
		prioComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
		});

		/* ---------------- LISTVIEW ---------------- */
		empresaLista.getItems().addAll("Empresa autónoma 1", "Empresa pequeña S. L.", "Empresa grande S. A.",
				"Empresa pequeña S. L. U.", "Empresa autónoma 2", "Empresa autónoma 3");
		empresaLista.setCellFactory(TextFieldListCell.forListView());
		empresaLista.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		/* ---------------- TREEVIEW ---------------- */
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

			// Para que sea editable necesitamos especificar un CellFactory con el tipo que corresponda
			treeEmpresas.setCellFactory(TextFieldTreeCell.forTreeView());

			// Expadimos por defecto el ítem raíz
			rootItem.setExpanded(true);
			treeEmpresas.setRoot(rootItem);

		/* ---------------- EVENTOS DE TECLADO ---------------- */
		// NO PERMITIR QUE LA EDAD SEAN CARACTERES ALFABÉTICOS Y SEAN COMO MÁXIMO 2 DÍGITOS
			edadForm.addEventFilter(KeyEvent.KEY_TYPED, e -> {
				if (!Character.isDigit(e.getCharacter().charAt(0)) || edadForm.getText().length() >= 2) {
					e.consume();
					System.out.println("Caracter: " + e.getCharacter() + ", no permitido");
				} else {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				}
			});
			
		// NO PERMITIR QUE EL TELÉFONO SEAN CARACTERES ALFABÉTICOS Y SEAN COMO MÁXIMO 9 DÍGITOS
			telForm.addEventFilter(KeyEvent.KEY_TYPED, e -> {
				if (!Character.isDigit(e.getCharacter().charAt(0)) || telForm.getText().length() >= 9) {
					e.consume();
					System.out.println("Caracter: " + e.getCharacter() + ", no permitido");
				} else {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				}
			});
			
		// NÓ PERMITIR QUE LOS NOMBRES TENGAN CARACTERES ESPECIALES O SEAN NÚMEROS
			nombreForm.addEventFilter(KeyEvent.KEY_TYPED, e -> {
				if (Character.isWhitespace(e.getCharacter().charAt(0))) {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				} else if (Character.isDigit(e.getCharacter().charAt(0))
						|| !Character.isAlphabetic(e.getCharacter().charAt(0))) {
					e.consume();
					System.out.println("Caracter: " + e.getCharacter() + ", no permitido");
				} else {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				}
			});
			
		// NO PERMITIR QUE LOS DNI TENGAN CARACTERES ESPECIALES Y LA LONGITUD SEA COMO MÁXIMO 9 NÚMEROS
			dniForm.addEventFilter(KeyEvent.KEY_TYPED, e -> {
				if (Character.isDigit(e.getCharacter().charAt(0)) && dniForm.getText().length() < 9) {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				} else if (Character.isAlphabetic(e.getCharacter().charAt(0)) && dniForm.getText().length() < 9) {
					System.out.println("Caracter: " + e.getCharacter() + ", permitido");
				} else {
					e.consume();
					System.out.println("Caracter: " + e.getCharacter() + ", no permitido");
				}
			});
	}

	/**
	 * MÉTODO PARA AÑADIR DATOS A LA TABLA TRABAJADORES
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void addDatos(ActionEvent event) {
		// Creamos un alert de tipo error, con su nombre y su header ya que no cambiará a diferencia del contenido
		Alert infoAlert = new Alert(AlertType.ERROR);
		infoAlert.setTitle("Aviso");
		infoAlert.setHeaderText("¡Se ha producido un error!");
		
		// Cambiamos el cursor mientras se encuentre dentro del Alert
		infoAlert.getDialogPane().setCursor(Cursor.WAIT);

		// Cambiamos el icono del aviso
		Stage stageAlert = (Stage) infoAlert.getDialogPane().getScene().getWindow();
		stageAlert.getIcons().add(new Image("img/warning.png"));
		
		// Cambiar la imagen del aviso
		infoAlert.getDialogPane().setGraphic(new ImageView("img/warning.png"));

		// Para cambiar el estilo del aviso, dependiendo de si está en modo claro u oscuro
		Scene panel = (Scene) tablaTrabajadores.getScene();
		if (panel.getStylesheets().toString().equals("[practica/view/css/applight.css]")) {
			DialogPane dialogPane = infoAlert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialoglight.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
			
		} else if (panel.getStylesheets().toString().equals("[practica/view/css/appdark.css]")) {
			DialogPane dialogPane = infoAlert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialogdark.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
		}

		// Añadimos un filtro que no nos permitirá salir del Dialogo si pulsamos escape o enter, para salir habrá que pulsar el botón de aceptar
		stageAlert.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			System.out.println(" -> " + e.getCode().toString());
			if (e.getCode() == ESCAPE) {
				e.consume();
			}
			if (e.getCode() == ENTER) {
				e.consume();
			}
		});

		// Permitimos que la tabla de trabajadores pueda ser editado
		tablaTrabajadores.setEditable(true);

		// Añadimos datos a la tabla
		String nombreTrabajador = nombreForm.getText();
		String dniTrabajador = dniForm.getText();
		String edadT = edadForm.getText();
		RadioButton sexoElegido = (RadioButton) sexo.getSelectedToggle();
		String espTrabajador = espChoiceBox.getValue();
		String telT = telForm.getText();
		String emailTrabajador = emailForm.getText();

		// Da un aviso (dialog) si alguno de los campos está vacío
		if (nombreTrabajador.trim().isEmpty() || dniTrabajador.trim().isEmpty() || edadT.trim().isEmpty()
				|| sexoElegido == null || telT.trim().isEmpty() || emailTrabajador.isEmpty()) {
			infoAlert.setContentText("Los campos no pueden estar vacíos. Introduzca los datos de nuevo.");
			infoAlert.showAndWait();
		} else if (espTrabajador.equals("Selecciona la especialización.")) {
			infoAlert.setContentText("Tienes que especificar una especialización.");
			infoAlert.showAndWait();
		} else {

			// Se parsea los datos de ser necesario
			int edadTrabajador = Integer.parseInt(edadT);
			int telefonoTrabajador = Integer.parseInt(telT);
			String sexoTrabajador = sexoElegido.getText();
			
			// Se añade al ObservableList el nuevo Empleado
			datos.add(new Person(nombreTrabajador, dniTrabajador, edadTrabajador, sexoTrabajador, espTrabajador, telefonoTrabajador, emailTrabajador));

			// Se deja en limpio el formulario
			nombreForm.clear();
			dniForm.clear();
			edadForm.clear();
			telForm.clear();
			emailForm.clear();
			sexo.getSelectedToggle().setSelected(false);
			espChoiceBox.setValue("Selecciona la especialización.");
		}
	}
	
	/**
	 * MÉTODO PARA ELIMINAR DATOS DE LA TABLA TRABAJADORES
	 * @param event Nombre del evento que se produce
	 */
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
		
		// Para cambiar el estilo del aviso, dependiendo de si está en modo claro u oscuro
		Scene panel = (Scene) tablaTrabajadores.getScene();
		if (panel.getStylesheets().toString().equals("[practica/view/css/applight.css]")) {
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialoglight.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
		} else if (panel.getStylesheets().toString().equals("[practica/view/css/appdark.css]")) {
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialogdark.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
		}
		
		// Imagen
		alert.getDialogPane().setGraphic(new ImageView("img/help.png"));

		// Icono
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("img/help.png"));

		// Añadimos un filtro que no nos permitirá salir del Dialogo si pulsamos escape o enter, para salir habrá que pulsar el botón de aceptar
		stage.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			System.out.println(" -> " + e.getCode().toString());
			if (e.getCode() == ESCAPE) {
				e.consume();
			}
			if (e.getCode() == ENTER) {
				e.consume();
			}
		});

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

	/**
	 * MÉTODO PARA AÑADIR DATOS A LA TABLA DE CITAS
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void addDates(ActionEvent event) {
		// Creamos el dialogo de tipo alert, de tipo error, con su nombre y su header ya
		// que no cambiará a diferencia del contenido
		Alert infoAlert = new Alert(AlertType.ERROR);
		infoAlert.setTitle("Aviso");
		infoAlert.setHeaderText("Se ha produido un error.");
		// Cambiamos el cursor mientras se encuentre dentro del Alert
		infoAlert.getDialogPane().setCursor(Cursor.WAIT);

		// Cambiamos el icono del aviso
		Stage stageAlert = (Stage) infoAlert.getDialogPane().getScene().getWindow();
		stageAlert.getIcons().add(new Image("img/warning.png"));
		
		// Cambiar el grafico
		infoAlert.getDialogPane().setGraphic(new ImageView("img/warning.png"));

		// Para cambiar el estilo del aviso, dependiendo de si está en modo claro u
				// oscuro
				Scene panel = (Scene) tablaTrabajadores.getScene();
				if (panel.getStylesheets().toString().equals("[practica/view/css/applight.css]")) {
					DialogPane dialogPane = infoAlert.getDialogPane();
					dialogPane.getStylesheets().add(getClass().getResource("dialoglight.css").toExternalForm());
					dialogPane.getStyleClass().add("dialog");
				} else if (panel.getStylesheets().toString().equals("[practica/view/css/appdark.css]")) {
					DialogPane dialogPane = infoAlert.getDialogPane();
					dialogPane.getStylesheets().add(getClass().getResource("dialogdark.css").toExternalForm());
					dialogPane.getStyleClass().add("dialog");
				}
		
		// Añadimos un filtro que no nos permitirá salir del Dialogo si pulsamos escape o enter, para salir habrá que pulsar el botón de aceptar
		stageAlert.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			System.out.println(" -> " + e.getCode().toString());
			if (e.getCode() == ESCAPE) {
				e.consume();
			}
			if (e.getCode() == ENTER) {
				e.consume();
			}
		});

		if (fechaForm.getValue() == null || horaForm.getText().toString().trim().isEmpty()
				|| asuntoForm.getText().toString().trim().isEmpty()) {
			infoAlert.setContentText("Los campos no pueden estar vacíos. Introduzca los datos de nuevo.");
			infoAlert.showAndWait();
		} else if (prioComboBox.getValue().toString().equals("Prioridad...")) {
			infoAlert.setContentText("Tienes que especificar la prioridad.");
			infoAlert.showAndWait();
		} else {
			// Permitimos que la tabla pueda ser editado
			tablaCitas.setEditable(true);

			// Añadimos datos a la tabla
			String fecha = fechaForm.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String hora = horaForm.getText();
			String asunto = asuntoForm.getText();
			String prioridad = prioComboBox.getValue();

			// Se añade en el Observable List la nueva cita
			citaciones.add(new Citas(fecha, hora, asunto, prioridad));

			// Se limpia el formulario
			fechaForm.getEditor().clear();
			horaForm.clear();
			asuntoForm.clear();
			prioComboBox.setValue("Prioridad...");
		}
	}

	/**
	 * MÉTODO PARA ELIMINAR DATOS DE LA TABLA DE CITAS
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void deleteDates(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Aviso");
		alert.setHeaderText("Esta acción es peligrosa.");
		alert.setContentText("Una vez confirmes esta acción, los datos no podrán ser restaurados.");

		// Icono
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("img/warning.png"));
		
		// Gráfico
		alert.getDialogPane().setGraphic(new ImageView("img/help.png"));

		// Para cambiar el estilo del aviso, dependiendo de si está en modo claro u oscuro
		Scene panel = (Scene) tablaTrabajadores.getScene();
		if (panel.getStylesheets().toString().equals("[practica/view/css/applight.css]")) {
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialoglight.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
		} else if (panel.getStylesheets().toString().equals("[practica/view/css/appdark.css]")) {
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialogdark.css").toExternalForm());
			dialogPane.getStyleClass().add("dialog");
		}
		
		// Añadimos un filtro que no nos permitirá salir del Dialogo si pulsamos escape o enter, para salir habrá que pulsar el botón de aceptar
		stage.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			System.out.println(" -> " + e.getCode().toString());
			if (e.getCode() == ESCAPE) {
				e.consume();
			}
			if (e.getCode() == ENTER) {
				e.consume();
			}
		});

		Optional<ButtonType> action = alert.showAndWait();
		if (action.get() == ButtonType.OK) {
			ObservableList<Citas> citaciones, allRows;
			allRows = tablaCitas.getItems();
			citaciones = tablaCitas.getSelectionModel().getSelectedItems();
			citaciones.forEach(allRows::remove);
		}
	}

	/**
	 * MÉTODO PARA ABRIR LA VENTANA DE TUTORIAL
	 * @param event Nombre del evento que se produce
	 */
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
			scene.getStylesheets().add("practica/view/css/tutorial.css");
			
			tutorialStage.setResizable(false);
			tutorialStage.setTitle("Tutorial.");
			tutorialStage.setScene(scene);
			tutorialStage.show();
			tutorialStage.getIcons().add(new Image("img/logo.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * MÉTODO QUE HACE QUE LA ESCENA TENGA UN ESTILO DIFERENTE (MODO CLARO)
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void claro(ActionEvent event) {
		Scene panel = (Scene) tablaTrabajadores.getScene();
		panel.getStylesheets().removeIf(style -> style.equals("practica/view/css/appdark.css"));
		panel.getStylesheets().add("practica/view/css/applight.css");
	}


	/**
	 * MÉTODO QUE HACE QUE LA ESCENA TENGA UN ESTILO DIFERENTE (MODO OSCURO)
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void oscuro(ActionEvent event) {
		Scene panel = (Scene) tablaTrabajadores.getScene();
		panel.getStylesheets().removeIf(style -> style.equals("practica/view/css/applight.css"));
		panel.getStylesheets().add("practica/view/css/appdark.css");
	}


	/**
	 * MÉTODO QUE HACE QUE LA ESCENA TENGA UN ESTILO DIFERENTE (MODO DEFECTO)
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void defecto(ActionEvent event) {
		Scene panel = (Scene) tablaTrabajadores.getScene();
		panel.getStylesheets().removeIf(style -> style.equals("practica/view/css/appdark.css")
				|| style.equals("practica/view/css/applight.css"));
	}

	/**
	 * MÉTODO QUE NOS HACE SALIR DE TODA LA APLICACIÓN
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	private void exitApp(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * MÉTODO QUE CIERRA SESIÓN DE LA APLICACIÓN Y HACE QUE VOLVAMOS A LA PANTALLA DE LOGIN
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	private void cerrarSesion(ActionEvent event) {
		Stage stage = (Stage) tablaTrabajadores.getScene().getWindow();
		stage.close();
		handleButtonLogout();
	}

	/**
	 * Método para realizar el cerrado de sesión
	 */
	private void handleButtonLogout() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/LogInLayout.fxml"));
			Stage loginStage = new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add("practica/view/css/login.css");
			loginStage.setTitle("Gestoría DJO S.L.");
			loginStage.setScene(scene);
			loginStage.show();
			loginStage.setResizable(false);
			loginStage.getIcons().add(new Image("img/logo.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
