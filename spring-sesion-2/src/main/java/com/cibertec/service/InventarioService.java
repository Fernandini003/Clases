package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cibertec.entity.Categoria;
import com.cibertec.entity.Inventario;
import com.cibertec.repository.InventarioRepository;

public class InventarioService {

	@Autowired // para instanciar una clase
	private InventarioRepository inventarioRepository;

	public Inventario crear(Inventario inventario) throws Exception {
		if (inventario.getFecha() == null) {
			throw new Exception("Debe ingrear la fecha de registro");
		}


		return inventarioRepository.save(inventario);
	}

	public Inventario editar(Inventario inventario) throws Exception {
		if (inventario.getFecha() == null) {
			throw new Exception("Debe ingrear la fecha de registro");
		}
		
		if (inventario.getCostoIngresos() == null) {
			throw new Exception("Debe ingrear la fecha de registro");
		}
		
		Inventario inventarioEdit = getInventario(inventario.getNroInventario());
		inventarioEdit.setFecha(inventario.getFecha());
		inventarioEdit.setCostoIngresos(inventario.getCostoIngresos());		
		
		return inventarioRepository.save(inventarioEdit);
	}

	public void eliminar(Integer nroInventario) {
		inventarioRepository.deleteById(nroInventario);	
	}
	
	public Inventario getInventario(Integer nroInventario) throws Exception {
		Optional<Inventario> optInventario = inventarioRepository.findById(nroInventario);
		if (optInventario.isEmpty()) {
			throw new Exception("El registro con ID: " + nroInventario + "No existe");
		}
		return optInventario.get();
	}


	public List<Inventario> getAll() {
		return inventarioRepository.findAll(); // trae todos las categorias
	}

}
