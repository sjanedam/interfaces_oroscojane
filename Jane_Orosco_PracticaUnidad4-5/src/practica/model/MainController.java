package practica.model;

import java.io.IOException;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private ImageView login;
	@FXML
	private BarChart<String, Integer> chartEmpresas;
	@FXML
	private CategoryAxis tamEmpresa;
	
	private ObservableList<String> tamEmpresas = FXCollections.observableArrayList();
		
	@FXML
	void initialize() {
		login.setCursor(Cursor.HAND);
		
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
		
	}

	@FXML
	void login(MouseEvent event) {
		Stage appStage = (Stage) login.getScene().getWindow();
		appStage.close();
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("practica/view/LogInLayout.fxml"));
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
	
	/* Métodos para añadir datos al barchart */
	private XYChart.Series<String, Integer> darDatosAnyo1() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2018");       
		series1.getData().add(new XYChart.Data<String, Integer>("Autónomos", 1));
		series1.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series1.getData().add(new XYChart.Data<String, Integer>("Medianas", 3));
		series1.getData().add(new XYChart.Data<String, Integer>("Grandes", 1));
		
		return series1;
	}
	private XYChart.Series<String, Integer> darDatosAnyo2() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2019");       
		series1.getData().add(new XYChart.Data<String, Integer>("Autónomos", 3));
		series1.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series1.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series1.getData().add(new XYChart.Data<String, Integer>("Grandes", 2));
		
		return series1;
	}
	private XYChart.Series<String, Integer> darDatosAnyo3() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2020");       
		series1.getData().add(new XYChart.Data<String, Integer>("Autónomos", 4));
		series1.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 3));
		series1.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series1.getData().add(new XYChart.Data<String, Integer>("Grandes", 3));
		
		return series1;
	}
	private XYChart.Series<String, Integer> darDatosAnyo4() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2021");       
		series1.getData().add(new XYChart.Data<String, Integer>("Autónomos", 6));
		series1.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 7));
		series1.getData().add(new XYChart.Data<String, Integer>("Medianas", 6));
		series1.getData().add(new XYChart.Data<String, Integer>("Grandes", 5));
		
		return series1;
	}
	private XYChart.Series<String, Integer> darDatosAnyo5() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2022");       
		series1.getData().add(new XYChart.Data<String, Integer>("Autónomos", 9));
		series1.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 10));
		series1.getData().add(new XYChart.Data<String, Integer>("Medianas", 9));
		series1.getData().add(new XYChart.Data<String, Integer>("Grandes", 5));
		
		return series1;
	}
}
