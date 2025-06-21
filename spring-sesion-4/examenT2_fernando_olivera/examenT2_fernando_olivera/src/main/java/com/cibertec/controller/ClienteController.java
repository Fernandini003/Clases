package com.cibertec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.entity.Cliente;
import com.cibertec.service.ClienteService;
import com.cibertec.service.TipoDocumentoService;

@Controller
public class ClienteController {

	private final ClienteService clienteService;
	private final TipoDocumentoService tipoDocumentoService; 

	public ClienteController(ClienteService clienteService, TipoDocumentoService tipoDocumentoService) {
		this.clienteService = clienteService;
		this.tipoDocumentoService = tipoDocumentoService;
	}

	@GetMapping("/cliente-lista")
	public String listarCliente(Model model) {
		List<Cliente> clienteList = clienteService.getAll();
		model.addAttribute("clienteLista", clienteList); 
		return "cliente-lista";
	}
	
	@GetMapping("/new-cliente")
	public String showNuevaCliente(Model model) {
		model.addAttribute("cliente", new Cliente());

		model.addAttribute("tiposDocumento", tipoDocumentoService.getAll());
		model.addAttribute("type", "N");
		return "cliente";
	}

	@GetMapping("/edit-cliente/{id}")
	public String showEditCliente(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("cliente", clienteService.getCliente(id));
		
			model.addAttribute("tiposDocumento", tipoDocumentoService.getAll());
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "cliente";
	}

	@GetMapping("/view-cliente/{id}")
	public String showViewCliente(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("cliente",clienteService.getCliente(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cliente";
	}

	@GetMapping("/remove-cliente/{id}")
	public String removeCliente(@PathVariable Integer id, Model model) {
		clienteService.eliminar(id);
		return "redirect:/cliente-lista";
	}


	@PostMapping("/save-cliente")
	public String saveCliente(@ModelAttribute Cliente cliente) {
		try {
           
			if (cliente.getIdCliente() == null) {
				clienteService.crear(cliente);
			} else {
				clienteService.editar(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/cliente-lista";
	}
}
