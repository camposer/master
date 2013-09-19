package com.emarket.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the libreria database table.
 * 
 */
@Entity
@Table(name="libreria")
public class Libreria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=9)
	private String cif;

	@Column(nullable=false, length=100)
	private String direccion;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="libreria")
	private List<Compra> compras;

	//bi-directional many-to-one association to Ofrece
	@OneToMany(mappedBy="libreria")
	private List<Ofrece> ofreces;

	public Libreria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}