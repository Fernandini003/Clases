package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/bienvenida")
	public String showBienvenida(@RequestParam(name = "name") String nombre, Model model) {
		model.addAttribute("name", nombre);
		return "greeting";
	}

	@GetMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	
}
