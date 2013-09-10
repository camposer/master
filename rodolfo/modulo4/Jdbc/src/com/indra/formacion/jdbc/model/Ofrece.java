package com.indra.formacion.jdbc.model;

import java.io.Serializable;

public class Ofrece implements Serializable {
	private static final long serialVersionUID = 8723860802036265547L;

	private Integer id;
	private Libro libro;
	private Libreria libreria;
	private Float precio;
	
	public Ofrece() {
	
	}

	public Ofrece(Libro libro, Libreria libreria, Float precio) {
		this.libro = libro;
		this.libreria = libreria;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Libreria getLibreria() {
		return libreria;
	}
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Ofrece [id=" + id + ", libro=" + libro + ", libreria="
				+ libreria + ", precio=" + precio + "]";
	}
	
	
}
