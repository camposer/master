package com.indra.formacion.spring;

public class HelloWorld implements IHolaMundo {
	private String name;
	private IPersona person;

	
	public HelloWorld() {
		this(null);
	}

	public HelloWorld(String name) {
		System.out.println("Constructor...");
		this.name = name;
	}
	
	@Override
	public void holaMundo() {
		String texto = "Hola mundo ";
		
		if (person != null)
			texto += person.toString();
		else
			texto += (name != null)?name:"";
		
		System.out.println(texto);
	}

	@Override
	public void setNombre(String nombre) {
		this.name = nombre;
	}
	
	@Override
	public void setPersona(Persona persona) {
		this.person = persona;
		
	}

}
