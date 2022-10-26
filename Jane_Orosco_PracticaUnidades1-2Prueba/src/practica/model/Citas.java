package practica.model;

import javafx.beans.property.SimpleStringProperty;

public class Citas {
	private SimpleStringProperty fecha;
	private SimpleStringProperty asunto;
	
	public Citas(String paramFecha, String paramAsunto) {
		super();
		this.fecha = new SimpleStringProperty(paramFecha);
		this.asunto = new SimpleStringProperty(paramAsunto);
	}
	
	public String getFecha() {
		return fecha.get();
	}
	public void setFecha(String paramFecha) {
		fecha.set(paramFecha);
	}
	public String getAsunto() {
		return asunto.get();
	}
	public void setAsunto(String paramAsunto) {
		fecha.set(paramAsunto);
	}
}
