package practica.model;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TutorialController {
	@FXML
	private MenuBar menu;

	@FXML
	private Pagination paginationMain;
	@FXML
	private Pagination paginationLogin;
	@FXML
	private Pagination paginationApp;
	
	@FXML
	private ProgressBar progressbarMain;
	@FXML
	private ProgressBar progressbarLogin;
	@FXML
	private ProgressBar progressbarApp;

	private ArrayList<String> imagenes = new ArrayList<String>();
	private ArrayList<String> loginImgs = new ArrayList<String>();
	
	@FXML
	void initialize() {
		// Se inicializa el listado
		this.imagenes(this.imagenes);
		this.login(this.loginImgs);

		// Se calcula el número de páginas en función de los ítems del listado
		// Si el número no es divisor del número de ítems, entonces se añade una página
		paginationMain.setPageCount(imagenes.size());
		paginationLogin.setPageCount(loginImgs.size());

		paginationMain.setPageFactory(n -> new ImageView(imagenes.get(n)));
		paginationLogin.setPageFactory(n-> new ImageView(loginImgs.get(n)));

		// Cada vez que se selecciona una página se cambia la barra de progreso
		paginationMain.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
			progressbarMain.setProgress((newValue.doubleValue() + 1) / paginationMain.getPageCount());
		});
		paginationLogin.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
			progressbarLogin.setProgress((newValue.doubleValue() + 1) / paginationLogin.getPageCount());
		});


		// Valor inicial de la barra de progreso
		progressbarMain.setProgress((double) 1 / paginationMain.getPageCount());
		progressbarLogin.setProgress((double) 1 / paginationLogin.getPageCount());
		
	}

	@FXML
	void exitApp(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void exitTutorial(ActionEvent event) {
		Stage stage = (Stage) menu.getScene().getWindow();
		stage.close();
	}
	
	private void imagenes(ArrayList<String> imagenes) {
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
		imagenes.add("img\\atras.png");
	}
	
	private void login(ArrayList<String> loginImgs) {
		loginImgs.add("img\\tutorial\\login.png");
	}
}
