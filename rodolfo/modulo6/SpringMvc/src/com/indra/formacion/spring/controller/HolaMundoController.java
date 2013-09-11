package com.indra.formacion.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.indra.formacion.spring.util.HolaMundo;

@Controller
public class HolaMundoController {
	@Autowired
	HolaMundo holaMundo;
	
	@RequestMapping("/holaMundo1")
	public @ResponseBody String holaMundo1() {
		return "<html><head></head><body>Hola mundo!</body></html>";
	}

	@RequestMapping("/holaMundo2")
	public @ResponseBody String holaMundo2() {
		return holaMundo.getMensaje();
	}

	@RequestMapping("/holaMundo3")
	public String holaMundo3(Model model) {
		model.addAttribute("mensaje", holaMundo.getMensaje());

		return "/holaMundo.jsp";
	}

	@RequestMapping("/holaMundo4")
	public ModelAndView holaMundo4() {
		return new ModelAndView("/holaMundo.jsp", "mensaje", holaMundo.getMensaje());
	}

}
