package com.emarket.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@Table(name="compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(nullable=false)
	private float montante;

	//bi-directional many-to-one association to Lector
	@ManyToOne
	@JoinColumn(name="lector_id", nullable=false)
	private Lector lector;

	//bi-directional many-to-one association to Libreria
	@ManyToOne
	@JoinColumn(name="libreria_id", nullable=false)
	private Libreria libreria;

	//bi-directional many-to-one association to Libro
	@ManyToOne
	@JoinColumn(name="libro_id", nullable=false)
	private Libro libro;

	public Compra() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public float getMontante() {
		return this.montante;
	}

	public void setMontante(float montante) {
		this.montante = montante;
	}

	public Lector getLector() {
		return this.lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
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