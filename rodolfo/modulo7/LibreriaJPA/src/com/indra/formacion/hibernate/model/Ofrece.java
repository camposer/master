package com.indra.formacion.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofrece database table.
 * 
 */
@Entity
@Table(name="ofrece")
@NamedQuery(name="Ofrece.findAll", query="SELECT o FROM Ofrece o")
public class Ofrece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float precio;

	//bi-directional many-to-one association to Libreria
	@ManyToOne
	@JoinColumn(name="libreria_id", nullable=false)
	private Libreria libreria;

	//bi-directional many-to-one association to Libro
	@ManyToOne
	@JoinColumn(name="libro_id", nullable=false)
	private Libro libro;

	public Ofrece() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Libreria getLibreria() {
		return this.libreria;
	}

	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}