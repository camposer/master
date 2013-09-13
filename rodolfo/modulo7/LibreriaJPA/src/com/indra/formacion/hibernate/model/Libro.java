package com.indra.formacion.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@Table(name="libro")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
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

	@Column(nullable=false, length=50)
	private String titulo;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="libro")
	private List<Compra> compras;

	//bi-directional many-to-one association to Ofrece
	@OneToMany(mappedBy="libro")
	private List<Ofrece> ofreces;

	public Libro() {
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

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setLibro(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setLibro(null);

		return compra;
	}

	public List<Ofrece> getOfreces() {
		return this.ofreces;
	}

	public void setOfreces(List<Ofrece> ofreces) {
		this.ofreces = ofreces;
	}

	public Ofrece addOfrece(Ofrece ofrece) {
		getOfreces().add(ofrece);
		ofrece.setLibro(this);

		return ofrece;
	}

	public Ofrece removeOfrece(Ofrece ofrece) {
		getOfreces().remove(ofrece);
		ofrece.setLibro(null);

		return ofrece;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", precio=" + precio
				+ ", titulo=" + titulo + "]";
	}

	
}