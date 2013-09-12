package com.emarket.util;

import java.util.LinkedList;
import java.util.List;

import com.emarket.to.Producto;

public abstract class ProductoUtil {
	private static List<Producto> productos;
	private static int contador;
	
	static {
		contador = 1;
		productos = new LinkedList<Producto>();
		
		agregar(new Producto("Portátiles", 590f));
		agregar(new Producto("DVD", 300f));
		agregar(new Producto("Cámaras", 250f));
	}
	
	public static void agregar(Producto p) {
		p.setId(contador++);
		productos.add(p);
	}
	
	private static int buscarProductoPorId(Integer id) {
		int idx = -1;
		
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getId() == id) {
				idx =  i;
				break;
			}
		}
		
		return idx;
	}
	
	public static void modificar(Producto p) {
		int idx = buscarProductoPorId(p.getId());
		if (idx != -1)
			productos.set(idx, p);
	}

	public static void eliminar(Integer id) {
		int idx = buscarProductoPorId(id);
		if (idx != -1)
			productos.remove(idx);
	}

	public static Producto obtener(Integer id) {
		int idx = buscarProductoPorId(id);
		if (idx != -1)
			return productos.get(idx);
		else
			return null;
	}
	
	public static List<Producto> obtenerTodos() {
		return productos;
	}
	
	public static void main(String[] args) {
		System.out.println(obtenerTodos());
		
		Producto p = obtener(2);
		p.setNombre("Teléfono");
		modificar(p);
		
		System.out.println(obtenerTodos());
		
		eliminar(2);
		
		System.out.println(obtenerTodos());
	}
}
