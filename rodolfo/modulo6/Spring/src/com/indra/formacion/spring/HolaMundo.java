package com.indra.formacion.spring;

public class HolaMundo implements IHolaMundo {
	private String nombre;
	private IPersona persona;
	
	public HolaMundo() {
		this(null);
	}

	public HolaMundo(String nombre) {
		System.out.println("Constructor...");
		this.nombre = nombre;
	}
	
	public void holaMundo() {
		String texto = "Hola mundo ";
		
		if (persona != null)
			texto += persona.toString();
		else
			texto += (nombre != null)?nombre:"";
		
		System.out.println(texto);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setPersona(Persona persona) {
		this.persona = persona;
		
	}
	
	
}
