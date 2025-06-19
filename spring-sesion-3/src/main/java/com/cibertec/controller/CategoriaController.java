package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.entity.Categoria;
import com.cibertec.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/categoria-list")
	public String listaCategoria(Model model) {
		List<Categoria> categoriaList = categoriaService.getAll();

		model.addAttribute("categoriaList", categoriaList);

		return "categoria-list";
	}

	@GetMapping("/new-categoria")
	public String showNuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("type", "N");
		return "categoria";
	}

	@GetMapping("/edit-categoria/{id}")
	public String showEditCategoria(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("categoria", categoriaService.getCategoria(id));
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoria";
	}

	@GetMapping("/view-categoria/{id}")
	public String showViewCategoria(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("categoria", categoriaService.getCategoria(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoria";
	}

	@GetMapping("/remove-categoria/{id}")
	public String removeCategoria(@PathVariable Integer id, Model model) {
		categoriaService.eliminar(id);
	
		return "redirect:/categoria-list";
	}

	@PostMapping("/save-new-categoria")
	public String saveNewCategoria(@ModelAttribute Categoria categoria) {
		try {
			categoriaService.crear(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/categoria-list";
	}
	
	@PostMapping("/save-edit-categoria")
	public String saveEditCategoria(@ModelAttribute Categoria categoria) {
		try {
			categoriaService.editar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/categoria-list";
	}

}
