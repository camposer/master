package com.indra.formacion.jdbc.front;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.indra.formacion.jdbc.exception.CustomException;
import com.indra.formacion.jdbc.model.Libreria;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;
import com.indra.formacion.jdbc.service.ILibroService;
import com.indra.formacion.jdbc.service.LibroServiceFactory;

public class Principal {

	public void menu() throws CustomException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Título? ");
			String titulo = scanner.nextLine();
			System.out.println("Autor? ");
			String autor = scanner.nextLine();
			System.out.println("Precio? ");
			String sprecio = scanner.nextLine();
			System.out.println("Libreria id? ");
			String slibreriaId = scanner.nextLine();
			
			Libreria libreria = new Libreria();
			libreria.setId(Integer.parseInt(slibreriaId));
						
			Libro libro = null;
			
			Ofrece o = new Ofrece(libro, libreria, Float.parseFloat(sprecio));
			List<Ofrece> ofreces = new LinkedList<Ofrece>();
			ofreces.add(o);
			
			libro = new Libro(titulo, autor, Float.parseFloat(sprecio), ofreces);
			ILibroService libroService = LibroServiceFactory.createLibroService();
			libroService.agregarLibro(libro);
			
			System.out.println(libroService.obtenerLibros());
		}
	}
	
	public static void main(String[] args) throws CustomException {
		new Principal().menu();
	}

}
