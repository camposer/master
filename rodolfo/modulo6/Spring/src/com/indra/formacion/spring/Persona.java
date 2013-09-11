package com.indra.formacion.spring;

public class Persona implements IPersona {
	private static final long serialVersionUID = -994822350493344548L;

	private String nombre;
	private String apellido;
	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
