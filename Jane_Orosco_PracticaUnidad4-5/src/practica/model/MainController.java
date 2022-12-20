package practica.model;

import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private ImageView login;
    @FXML
    private ImageView exit;
    
	@FXML
	private BarChart<String, Integer> chartEmpresas;
	@FXML
	private CategoryAxis tamEmpresa;
	private ObservableList<String> tamEmpresas = FXCollections.observableArrayList();
	
	@FXML
	private PieChart pieChart;
	private ObservableList<PieChart.Data> numClientes  = FXCollections.observableArrayList();;
	
    @FXML
    private Label dateLabel;

    @FXML
    private Slider dateSlider;
    
    @FXML
    private Button scheduleButton;

	/* ---------------- MÉTODOS ---------------- */		
	/** INICIALIZAR */
	@FXML
	void initialize() {
		login.setCursor(Cursor.HAND);
		exit.setCursor(Cursor.HAND);
		scheduleButton.setCursor(Cursor.HAND);
		
		// Inicializar el listado de Tamaños de empresa que se añadirán en el eje X del gráfico
		String[] tamanyo = new String[] {"Autónomos", "Pequeñas", "Medianas", "Grandes"};
		tamEmpresas.addAll(Arrays.asList(tamanyo));
		
		// Asignar los valores al eje X
		tamEmpresa.setCategories(tamEmpresas);
		
		// Se añaden series al gráfico de tipo Barchart
		chartEmpresas.getData().add(darDatosAnyo1());
		chartEmpresas.getData().add(darDatosAnyo2());
		chartEmpresas.getData().add(darDatosAnyo3());
		chartEmpresas.getData().add(darDatosAnyo4());
		chartEmpresas.getData().add(darDatosAnyo5());
		
		// Se añaden datos al PieChart
		numClientes.add(new PieChart.Data("Empresas", 34));
		numClientes.add(new PieChart.Data("Abogados", 102));
		numClientes.add(new PieChart.Data("Notaría", 96));
		numClientes.add(new PieChart.Data("Seguros", 84));
		numClientes.add(new PieChart.Data("Asesoría", 76));
		
		pieChart = new PieChart(numClientes);
		pieChart.setTitle("Cantidad que confia en nsotoros");
		
		dateSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				double newnum= (double) arg1;
				if (Math.round(newnum) == 2018) { //7
					dateLabel.textProperty().setValue("Al principio eran 7 empresas quienes confiaban en nuestro servicio.");
				} else if (Math.round(newnum) == 2019) {// 11
					dateLabel.textProperty().setValue("No crecimos mucho en 2019, pero ya eran 11 empresas confiando en nosotros.");
				} else if (Math.round(newnum) == 2020) {// 14
					dateLabel.textProperty().setValue("En 2020 se añadieron 3 empresas más, ya eran 14 empresas en nuestras manos.");
				} else if (Math.round(newnum) == 2021) {// 24
					dateLabel.textProperty().setValue("Pero a partir de 2021 crecimos mucho y ya eran 24 empresas las que confiaban en nuestro trabajo.");
				} else {// 33
					dateLabel.textProperty().setValue("Actualmente son 33 empresas las que confían en nosotros y ¡la tuya es la próxima!");
				}
			}
		});
		
	}
	
	/** MOSTRAR UN DIÁLOGO PARA MOSTRAR HORARIOS ESPECIALES */
	@FXML
    void openSchedule(ActionEvent event) {
		Alert horarioAlert = new Alert(AlertType.INFORMATION);
		horarioAlert.setTitle("Horarios especiales");
		horarioAlert.setHeaderText("Semana Santa");
		horarioAlert.setContentText("08:00-17:00");
		horarioAlert.showAndWait();
		
		/* DialogPane dialogPane = horarioAlert.getDialogPane();
		dialogPane.getStylesheets().add(
				getClass().getResource("practica/view/css/main.css").toExternalForm()); */
    }

	/** PANTALLA DE LOGIN (INICIO DE SESIÓN) */
	@FXML
	void login(MouseEvent event) {
		Stage appStage = (Stage) login.getScene().getWindow();
		appStage.close();
		
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
			loginStage.getIcons().add(new Image("img/login.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** SALIR DE LA APLICACIÓN */
    @FXML
    void exit(MouseEvent event) {
    	System.exit(0);
    }
	
	/** MÉTODOS PARA AÑADOR DATOS AL BARCHART */
	private XYChart.Series<String, Integer> darDatosAnyo1() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2018");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 1));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 1));
		
		return series;
	}
	private XYChart.Series<String, Integer> darDatosAnyo2() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2019");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 2));
		
		return series;
	}
	private XYChart.Series<String, Integer> darDatosAnyo3() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2020");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 3));
		
		return series;
	}
	private XYChart.Series<String, Integer> darDatosAnyo4() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2021");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 6));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 7));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 6));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 5));
		
		return series;
	}
	private XYChart.Series<String, Integer> darDatosAnyo5() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2022");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 9));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 10));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 9));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 5));
		
		return series;
	}
}