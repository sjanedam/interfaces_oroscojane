package practica.model;

import javafx.beans.property.SimpleStringProperty;

public class Citas {
	private SimpleStringProperty fecha;
	private SimpleStringProperty hora;
	private SimpleStringProperty asunto;
	private SimpleStringProperty prioridad;
	
	public Citas(String paramFecha, String paramHora, String paramAsunto, String paramPrioridad) {
		super();
		this.fecha = new SimpleStringProperty(paramFecha);
		this.hora = new SimpleStringProperty(paramHora);
		this.asunto = new SimpleStringProperty(paramAsunto);
		this.prioridad = new SimpleStringProperty(paramPrioridad);
	}
	
	public String getFecha() {
		return fecha.get();
	}
	public void setFecha(String paramFecha) {
		fecha.set(paramFecha);
	}
	public String getHora() {
		return hora.get();
	}
	public void setHora(String paramHora) {
		hora.set(paramHora);
	}
	public String getAsunto() {
		return asunto.get();
	}
	public void setAsunto(String paramAsunto) {
		fecha.set(paramAsunto);
	}
	public String getPrioridad() {
		return prioridad.get();
	}
	public void setPrioridad(String paramPrioridad) {
		prioridad.set(paramPrioridad);
	}
}
