package com.indra.formacion.jdbc.model;

import java.io.Serializable;
import java.util.List;

public class Libreria implements Serializable {
	private static final long serialVersionUID = -3144273704037227140L;

	private Integer id;
	private String cif;
	private String nombre;
	private String direccion;
	private List<Ofrece> ofreces;
	
	public Libreria() { }

	public Libreria(String cif, String nombre, String direccion) {
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Libreria [id=" + id + ", cif=" + cif + ", nombre=" + nombre
				+ ", direccion=" + direccion + "]";
	}

	public List<Ofrece> getOfreces() {
		return ofreces;
	}

	public void setOfreces(List<Ofrece> ofreces) {
		this.ofreces = ofreces;
	}
}
