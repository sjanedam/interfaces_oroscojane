package practica.model;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controlador de la ventana de Tutorial
 * @author Jane Orosco
 *
 */
public class TutorialController {
	/* INICIALIZAMOS LAR VARIABLES @FXML */
	@FXML
	private MenuBar menu;

	@FXML
	private Pagination paginationLogin;
	@FXML
	private Pagination paginationApp;
	
	@FXML
	private ProgressBar progressbarLogin;
	@FXML
	private ProgressBar progressbarApp;

	private ArrayList<String> loginImgs = new ArrayList<String>();
	private ArrayList<String> appImgs = new ArrayList<>();
	
	/**
	 * MÉTODO EN EL QUE SE INICIALIZAN LOS DATOS
	 * 
	 */
	@FXML
	void initialize() {
		// Se inicializa el listado
		this.login(this.loginImgs);
		this.app(this.appImgs);

		// Se calcula el número de páginas en función de los ítems del listado
		// Si el número no es divisor del número de ítems, entonces se añade una página
		paginationLogin.setPageCount(loginImgs.size());
		paginationApp.setPageCount(appImgs.size());

		paginationLogin.setPageFactory(n-> new ImageView(loginImgs.get(n)));
		paginationApp.setPageFactory(s-> new ImageView(appImgs.get(s)));

		// Cada vez que se selecciona una página se cambia la barra de progreso
		paginationLogin.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
			progressbarLogin.setProgress((newValue.doubleValue() + 1) / paginationLogin.getPageCount());
		});
		paginationApp.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
			progressbarApp.setProgress((newValue.doubleValue() + 1) / paginationApp.getPageCount());
		});


		// Valor inicial de la barra de progreso
		progressbarLogin.setProgress((double) 1 / paginationLogin.getPageCount());
		progressbarApp.setProgress((double) 1 / paginationApp.getPageCount()); 
	}

	/**
	 * MÉTODO QUE NOS HACE SALIR DE TODA LA APLICACIÓN
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void exitApp(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * MÉTODO PARA CERRAR LA VENTANA DE TUTORIAL
	 * @param event Nombre del evento que se produce
	 */
	@FXML
	void exitTutorial(ActionEvent event) {
		Stage stage = (Stage) menu.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Método en el que se listan las rutas de las imagenes del tutorial de la app
	 * @param appImgs Nombre del Arraylist<String>
	 */
	private void app(ArrayList<String> appImgs) {
		appImgs.add("img\\tutorial\\app\\app.png");
		appImgs.add("img\\tutorial\\app\\menu.jpg");
		appImgs.add("img\\tutorial\\app\\menuapp1.jpg");
		appImgs.add("img\\tutorial\\app\\menuapp2.jpg");
		appImgs.add("img\\tutorial\\app\\menuapp3.jpg");
		appImgs.add("img\\tutorial\\app\\tutorial.jpg");
		appImgs.add("img\\tutorial\\app\\estilodefault.jpg");
		appImgs.add("img\\tutorial\\app\\estiloclaro1.jpg");
		appImgs.add("img\\tutorial\\app\\estiloclaro2.jpg");
		appImgs.add("img\\tutorial\\app\\estilooscuro1.jpg");
		appImgs.add("img\\tutorial\\app\\estilooscuro2.jpg");
		
		appImgs.add("img\\tutorial\\app\\tab1.jpg");
		appImgs.add("img\\tutorial\\app\\tab1table.jpg");
		appImgs.add("img\\tutorial\\app\\tab1add.jpg");
		appImgs.add("img\\tutorial\\app\\tab1addaviso.jpg");
		appImgs.add("img\\tutorial\\app\\tab1deleteaviso.jpg");
		appImgs.add("img\\tutorial\\app\\tab2.jpg");
		appImgs.add("img\\tutorial\\app\\tab2table.jpg");
		appImgs.add("img\\tutorial\\app\\tab2add.jpg");
		appImgs.add("img\\tutorial\\app\\tab2addaviso.jpg");
		appImgs.add("img\\tutorial\\app\\tab2deleteaviso.jpg");
		appImgs.add("img\\tutorial\\app\\tab3.jpg");
		appImgs.add("img\\tutorial\\app\\tab4.jpg");

	}
	
	/**
	 * Método en el que se listan las rutas de las imagenes del tutorial del login
	 * @param loginImgs  Nombre del Arraylist<String>
	 */
	private void login(ArrayList<String> loginImgs) {
		loginImgs.add("img\\tutorial\\login\\login.png");
		loginImgs.add("img\\tutorial\\login\\cerrarsesion.jpg");
		loginImgs.add("img\\tutorial\\login\\exit.jpg");
		loginImgs.add("img\\tutorial\\login\\user.jpg");
		loginImgs.add("img\\tutorial\\login\\password.jpg");
		loginImgs.add("img\\tutorial\\login\\userfail.jpg");
		loginImgs.add("img\\tutorial\\login\\passwordfail.jpg");
		loginImgs.add("img\\tutorial\\login\\login.jpg");
	}
}
