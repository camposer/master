package com.indra.formacion.spring.model;

import java.io.Serializable;
import java.util.List;

public class Vino implements Serializable {
	private String nombre;
	private Integer anio;
	private List<String> categorias; 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	
	
}
