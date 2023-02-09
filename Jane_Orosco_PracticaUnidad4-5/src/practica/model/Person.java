package practica.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Clase Person, con sus respectivos atributos, constructor y getters y setters
 * @author Jane Orosco
 *
 */
public class Person {
	private SimpleStringProperty nombre;
    private SimpleStringProperty dni;
    private SimpleIntegerProperty edad;
    private SimpleStringProperty sexo;
    private SimpleStringProperty especializacion;
    private SimpleIntegerProperty telefono;
    private SimpleStringProperty email;
    
    /**
     * Constructor de la clase Person
     * @param paramNombre Nombre de la persona
     * @param paramDNI DNI de la persona
     * @param paramEdad Edad de la persona
     * @param paramSexo Sexo de la persona
     * @param paramEspecializacion Especialización de la persona
     * @param paramTelefono Teléfono de la persona
     * @param paramEmail Email de la persona
     */
    public Person(String paramNombre, String paramDNI, Integer paramEdad,
    		String paramSexo, String paramEspecializacion, Integer paramTelefono,
    		String paramEmail) {
		super();
		this.nombre = new SimpleStringProperty(paramNombre);
		this.dni = new SimpleStringProperty(paramDNI);
		this.edad = new SimpleIntegerProperty(paramEdad);
		this.sexo = new SimpleStringProperty(paramSexo);
		this.especializacion = new SimpleStringProperty(paramEspecializacion);
		this.telefono = new SimpleIntegerProperty(paramTelefono);
		this.email = new SimpleStringProperty(paramEmail);
	}
 
    public String getNombre() {
    	return nombre.get();
    }
    public void setNombre(String paramNombre) {
    	nombre.set(paramNombre);
    }
    public String getDni() {
    	return dni.get();
    }
    public void setDni(String paramDNI) {
    	dni.set(paramDNI);
    }
    public Integer getEdad() {
    	return edad.get();
    }
    public void setEdad(Integer paramEdad) {
    	edad.set(paramEdad);
    }
    public String getSexo() {
    	return sexo.get();
    }
    public void setSexo(String paramSexo) {
    	sexo.set(paramSexo);
    }
    public String getEspecializacion() {
    	return especializacion.get();
    }
    public void setEspecializacion(String paramEspecializacion) {
    	sexo.set(paramEspecializacion);
    }
    public Integer getTelefono() {
    	return telefono.get();
    }
    public void setTelefono(Integer paramTelefono) {
    	edad.set(paramTelefono);
    }
    public String getEmail() {
    	return email.get();
    }
    public void setEmail(String paramEmail) {
    	email.set(paramEmail);
    }
        
}