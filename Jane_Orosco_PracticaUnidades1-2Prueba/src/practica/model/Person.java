package practica.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
	private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellido;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty edad;
    
    public Person(String paramNombre, String paramApellido, String paramEmail, Integer paramEdad) {
    	this.nombre = new SimpleStringProperty(paramNombre);
    	this.apellido = new SimpleStringProperty(paramApellido);
    	this.email = new SimpleStringProperty(paramEmail);
    	this.edad = new SimpleIntegerProperty(paramEdad);
    }
 
    public String getNombre() {
    	return nombre.get();
    }
    public void setNombre(String paramNombre) {
    	nombre.set(paramNombre);
    }
    public String getApellido() {
    	return apellido.get();
    }
    public void setApellido(String paramApellido) {
    	apellido.set(paramApellido);
    }
    public String getEmail() {
    	return email.get();
    }
    public void setEmail(String paramEmail) {
    	email.set(paramEmail);
    }
    public Integer getEdad() {
    	return edad.get();
    }
    public void setEdad(Integer paramEdad) {
    	edad.set(paramEdad);
    }
        
}