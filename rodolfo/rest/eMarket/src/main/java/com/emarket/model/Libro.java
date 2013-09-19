package com.emarket.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@Table(name="libro")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String autor;

	@Column(nullable=false)
	private float precio;

	@Column(nullable=false, length=100)
	private String titulo;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="libro")
	@JsonIgnore
	private List<Compra> compras;

	//bi-directional many-to-one association to Ofrece
	@OneToMany(mappedBy="libro")
	@JsonIgnore
	private List<Ofrece> ofreces;
	
	@Transient // No cuenta a la hora de persistir!
	@JsonIgnore
	private List<Libreria> librerias;
	

	public Libro() {
	}

	public Libro(String titulo, String autor, Float precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Ofrece> getOfreces() {
		return this.ofreces;
	}

	public void setOfreces(List<Ofrece> ofreces) {
		this.ofreces = ofreces;
	}
	
	

	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	@Override
	public String toString() {
		return "(id: " + id + ", titulo: " + titulo + ", autor: " + autor + ", precio: " + precio + ")";
	}
}