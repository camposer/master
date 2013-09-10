package com.indra.formacion.jdbc.model;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable {
	private static final long serialVersionUID = 2723434081633858256L;

	private Integer id;
	private String titulo;
	private String autor;
	private Float precio;
	private List<Ofrece> ofreces;
	
	public Libro() {
		this(null, null, null);
	}

	public Libro(String titulo, String autor, Float precio) {
		this(titulo, autor, precio, null);
	}

	public Libro(String titulo, String autor, Float precio, List<Ofrece> ofreces) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.ofreces = ofreces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	public List<Ofrece> getOfreces() {
		return ofreces;
	}

	public void setOfreces(List<Ofrece> ofreces) {
		this.ofreces = ofreces;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor
				+ ", precio=" + precio + "]";
	}
}
