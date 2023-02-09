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
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador de la página principal de la aplicación (Main)
 * @author Jane Orosco
 *
 */
public class MainController {
	/* INICIALIZAMOS LAR VARIABLES @FXML */
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
	private ObservableList<PieChart.Data> numProfesionales = FXCollections.observableArrayList();
	
	@FXML
	private StackedAreaChart<Integer, Integer> stackArea;
	
    @FXML
    private Label dateLabel;

    @FXML
    private Slider dateSlider;
    
    @FXML
    private Button scheduleButton;
    
    @FXML
    private Hyperlink link;
   

	/* ---------------- MÉTODOS ---------------- */		
    /**
	 * MÉTODO EN EL QUE SE INICIALIZAN LOS DATOS
	 * 
	 */
	@FXML
	void initialize() {
		/* CURSOR */
		login.setCursor(Cursor.HAND);
		exit.setCursor(Cursor.HAND);
		scheduleButton.setCursor(Cursor.HAND);
		
		/* --------------- BARCHART --------------- */
			// Inicializar el listado de empresaS que se añadirán en el eje X del gráfico
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
		
		/* --------------- PIECHART --------------- */
			// Se añaden datos al ObservableList 
			numProfesionales.add(new PieChart.Data("Empresarios", 2));
			numProfesionales.add(new PieChart.Data("Abogados", 3));
			numProfesionales.add(new PieChart.Data("Notarios", 2));
			numProfesionales.add(new PieChart.Data("Seguros", 2));
			numProfesionales.add(new PieChart.Data("Aseguradores", 3));
			numProfesionales.add(new PieChart.Data("Adminsitrativos", 6));
			
			pieChart.setData(numProfesionales);
			pieChart.setTitle("El número de profesionales que trabaja con nosotros");
			
			// Se añade un tooltip a cada sección
			pieChart.getData().forEach(this::addTooltip);
		
		/* --------------- SLIDER --------------- */
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
		
		/* --------------- HYPERLINK --------------- */
			//TODO: Hyperlink funcionales
			link.setOnAction(e -> {
				System.out.println("Se ha vistado la página ");
			});
		
		/* --------------- STACKED AREA CHART --------------- */
			initStackedAreaChart();
		
	}
	
	/**
	 * MÉTODO PARA AÑADIR DATOS AL STACKED AREA CHART
	 * 
	 */
	private void initStackedAreaChart() {
        // Para los StackedAreaChart, SceneBuilder obliga a emplear dos NumberAxis cuyos valores deben ser Number o tipos que heredan de este
        
        // Se crean tantas series con como quiera tener en el gráfico
        XYChart.Series<Integer, Integer> anyo18 = new XYChart.Series<Integer, Integer>();
        anyo18.setName("Año 2018");
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(1, 10));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(2, 13));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(3, 17));        
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(4, 20));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(5, 25));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(6, 29));        
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(7, 31));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(8, 33));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(9, 33));        
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(10, 36));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(11, 38));
        anyo18.getData().add(new XYChart.Data<Integer, Integer>(12, 43));
        
        XYChart.Series<Integer, Integer> anyo19 = new XYChart.Series<Integer, Integer>();
        anyo19.setName("Año 2019");
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(1, 46));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(2, 49));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(3, 52));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(4, 59));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(5, 61));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(6, 62));        
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(7, 63));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(8, 65));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(9, 69));      
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(10, 70));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(11, 73));
        anyo19.getData().add(new XYChart.Data<Integer, Integer>(12, 79));
        
        XYChart.Series<Integer, Integer> anyo20 = new XYChart.Series<Integer, Integer>();
        anyo20.setName("Año 2020");
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(1, 81));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(2, 84));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(3, 89));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(4, 93));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(5, 99));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(6, 109));        
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(7, 124));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(8, 129));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(9, 133));      
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(10, 134));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(11, 140));
        anyo20.getData().add(new XYChart.Data<Integer, Integer>(12, 145));
        
        XYChart.Series<Integer, Integer> anyo21 = new XYChart.Series<Integer, Integer>();
        anyo21.setName("Año 2021");
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(1, 147));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(2, 139));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(3, 136));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(4, 133));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(5, 149));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(6, 151));        
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(7, 155));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(8, 159));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(9, 164));      
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(10, 160));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(11, 170));
        anyo21.getData().add(new XYChart.Data<Integer, Integer>(12, 178));
        
        XYChart.Series<Integer, Integer> anyo22 = new XYChart.Series<Integer, Integer>();
        anyo22.setName("Año 2022");
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(1, 178));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(2, 179));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(3, 187));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(4, 180));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(5, 171));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(6, 179));        
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(7, 188));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(8, 201));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(9, 207));      
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(10, 210));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(11, 218));
        anyo22.getData().add(new XYChart.Data<Integer, Integer>(12, 225));
        
        // Se añaden las series al gráfico de tipo AreaChart
        stackArea.getData().add(anyo18);
        stackArea.getData().add(anyo19);
        stackArea.getData().add(anyo20);
        stackArea.getData().add(anyo21);
        stackArea.getData().add(anyo22);
        
        // Se añade la información del Stacked Area
        stackArea.getXAxis().setLabel("Mes");
        stackArea.getYAxis().setLabel("Número de clientes");
        stackArea.setTitle("Total de clientes que usan nuestros servicios");
    }

	/**
	 * MÉTODO PARA AÑADIR UN TOOLTIP A CADA SECCIÓN DEL PIE CHART
	 * @param d Nombre que se le da a la variable de tipo PieChart.Data
	 */
	public void addTooltip(PieChart.Data d) {
		String msg = String.format("%s : %s", d.getName(), d.getPieValue());
		Tooltip tp = new Tooltip(msg);
		Tooltip.install(d.getNode(), tp);
	}
	
	/**
	 * MÉTODO PARA MOSTRAR UN DIALOG CON LOS HORARIOS ESPECIALES DE LA EMPRESA
	 * @param event Nombre del evento que se produce
	 */
	@FXML
    void openSchedule(ActionEvent event) {
		Alert horarioAlert = new Alert(AlertType.INFORMATION);
		horarioAlert.setTitle("Horarios especiales");
		horarioAlert.setHeaderText("Semana Santa");
		horarioAlert.setContentText("08:00-17:00");
		
		// Cambiar imagen
		horarioAlert.getDialogPane().setGraphic(new ImageView("img/horario.png"));
		
		// Cambiar logo
		Stage stageAlert = (Stage) horarioAlert.getDialogPane().getScene().getWindow();
		stageAlert.getIcons().add(new Image("img/horario.png"));

		// Cambiar estilo del dialogo
		DialogPane dialogPane = horarioAlert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("horarios.css").toExternalForm());
		dialogPane.getStyleClass().add("dialog");
		
		horarioAlert.showAndWait();
    }

	/**
	 * MÉTODO QUE CIERRA LA VENTANA ACTUAL Y LLAMA A LA PANTALLA DE INICIO DE SESIÓN
	 * @param event Nombre del evento que se produce
	 */
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
			loginStage.getIcons().add(new Image("img/logo.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MÉTODO QUE NOS HACE SALIR DE TODA LA APLICACIÓN
	 * @param event Nombre del evento que se produce
	 */
    @FXML
    void exit(MouseEvent event) {
    	System.exit(0);
    }
	
	/* -------------------- MÉTODOS PARA AÑADOR DATOS AL BARCHART ------------- */
    /**
     * MÉTODO QUE DEVUELVE LOS DATOS DE UN AÑO DEPENDIENDO DE LA EMPRESA
     * @return Datos que se recogen de un tipo de empresa en un año
     */
	private XYChart.Series<String, Integer> darDatosAnyo1() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2018");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 1));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 1));
		
		return series;
	}
	/**
     * MÉTODO QUE DEVUELVE LOS DATOS DE UN AÑO DEPENDIENDO DE LA EMPRESA
     * @return Datos que se recogen de un tipo de empresa en un año
     */
	private XYChart.Series<String, Integer> darDatosAnyo2() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2019");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 2));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 2));
		
		return series;
	}
	/**
     * MÉTODO QUE DEVUELVE LOS DATOS DE UN AÑO DEPENDIENDO DE LA EMPRESA
     * @return Datos que se recogen de un tipo de empresa en un año
     */
	private XYChart.Series<String, Integer> darDatosAnyo3() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2020");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 3));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 4));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 3));
		
		return series;
	}
	/**
     * MÉTODO QUE DEVUELVE LOS DATOS DE UN AÑO DEPENDIENDO DE LA EMPRESA
     * @return Datos que se recogen de un tipo de empresa en un año
     */
	private XYChart.Series<String, Integer> darDatosAnyo4() {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		
		series.setName("2021");       
		series.getData().add(new XYChart.Data<String, Integer>("Autónomos", 6));
		series.getData().add(new XYChart.Data<String, Integer>("Pequeñas", 7));
		series.getData().add(new XYChart.Data<String, Integer>("Medianas", 6));
		series.getData().add(new XYChart.Data<String, Integer>("Grandes", 5));
		
		return series;
	}
	/**
     * MÉTODO QUE DEVUELVE LOS DATOS DE UN AÑO DEPENDIENDO DE LA EMPRESA
     * @return Datos que se recogen de un tipo de empresa en un año
     */
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