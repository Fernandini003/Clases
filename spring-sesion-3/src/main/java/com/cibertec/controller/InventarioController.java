package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.entity.Inventario;
import com.cibertec.service.InventarioService;

@Controller
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;

	@GetMapping("/inventario-list")
	public String listaInventario(Model model) {
		List<Inventario> inventarioList = inventarioService.getAll();

		model.addAttribute("inventarioList", inventarioList);
		return "inventario-list";
	}

	@GetMapping("/new-inventario")
	public String showNuevoInventario(Model model) {
		model.addAttribute("inventario", new Inventario());
		model.addAttribute("type", "N");
		return "inventario";
	}

	@GetMapping("/edit-inventario/{id}")
	public String showEditInventario(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("inventario", inventarioService.getInventario(id));
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inventario";
	}

	@GetMapping("/view-inventario/{id}")
	public String showViewIventario(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("inventario", inventarioService.getInventario(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "inventario";
	}

	@GetMapping("/remove-inventario/{id}")
	public String removeInventario(@PathVariable Integer id, Model model) {
		inventarioService.eliminar(id);
		return "redirect:/inventario-list";
	}

	@PostMapping("/save-new-inventario")
	public String saveNewInventario(@ModelAttribute Inventario inventario) {
		try {
			inventarioService.crear(inventario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/inventario-list";
	}
	
	@PostMapping("/save-edit-inventario")
	public String saveInventario(@ModelAttribute Inventario inventario) {
		try {
			inventarioService.editar(inventario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/inventario-list";
	}
}
