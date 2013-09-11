package com.indra.formacion.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.formacion.spring.model.Vino;

@Controller
@RequestMapping("/vinos/*")
public class VinoController {
	
	@RequestMapping("")
	public String index() {
		return "redirect:/vinos/inicio.do"; // Equivalente a response.sendRedirect
	}

	@RequestMapping("inicio")
	public String inicio() {
		return "/inicio.jsp";
	}

	/*
	@RequestMapping("agregar")
	public String agregar1(HttpServletRequest request, Model model) {
		model.addAttribute("nombre", request.getParameter("nombre"));
		model.addAttribute("anio", request.getParameter("anio"));
		
		return "/agregar.jsp";
	}
	*/

	@RequestMapping("agregar")
	public String agregar1(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			@RequestParam("nombre") String name, 
			@RequestParam Integer anio,
			Vino vino,
			Model model) {
		
		model.addAttribute("nombre", vino.getNombre());
		model.addAttribute("anio", vino.getAnio());
		model.addAttribute("categorias", vino.getCategorias());
		session.setAttribute("mensaje", "Hola mundo!");
		
		return "/agregar.jsp";
	}

}
