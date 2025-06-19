package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.entity.Productos;
import com.cibertec.service.ProductosService;

@Controller
public class ProductosController {
	@Autowired
	private ProductosService productosService;

	@GetMapping("/productos-list")
	public String listaProductos(Model model) {
		List<Productos> productosList = productosService.getAll();

		model.addAttribute("productosList", productosList);
		return "productos-list";
	}

	@GetMapping("/new-productos")
	public String showNuevoProductos(Model model) {
		model.addAttribute("productos", new Productos());
		model.addAttribute("type", "N");
		return "productos";
	}

	@GetMapping("/edit-productos/{id}")
	public String showEditProductos(@PathVariable Integer id, Model model) {
		try {	
				model.addAttribute("productos", productosService.getProducto(id));
				model.addAttribute("type", "E");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "productos";
	}

	@GetMapping("/view-productos/{id}")
	public String showVieProductos(@PathVariable Integer id, Model model) {
		try {		
				model.addAttribute("productos", productosService.getProducto(id));
				model.addAttribute("type", "V");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "productos";
	}

	@GetMapping("/remove-productos/{id}")
	public String removeProductos(@PathVariable Integer id, Model model) {
		productosService.eliminar(id);
		return "redirect:/productos-list";
	}

	@PostMapping("/save-new-productos")
	public String saveNewProductos(@ModelAttribute Productos productos) {
		try {
			productosService.crear(productos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/productos-list";
	}

	@PostMapping("/save-edit-productos")
	public String saveProductos(@ModelAttribute  Productos productos) {
		try {
			productosService.editar(productos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/productos-list";
	}
}
