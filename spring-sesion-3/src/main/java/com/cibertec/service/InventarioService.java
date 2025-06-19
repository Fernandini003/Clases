package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Inventario;
import com.cibertec.repository.InventarioRepository;


@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventarioRepository;
	
	public Inventario crear(Inventario inventario) throws Exception {
		if (inventario.getCostoIngreso() == null) {
			throw new Exception("Debe ingresar costo de ingreso");
		}
		
		if (inventario.getFecha() == null) {
			throw new Exception("Debe ingresar la fecha");
		}
		
		if (inventario.getCostoIngreso() == null) {
			throw new Exception("Debe ingresar el costo de ingreso");
		}
		
		return inventarioRepository.save(inventario);
	}
	
	public Inventario editar(Inventario inventario) throws Exception {
		if (inventario.getCostoIngreso() == null) {
			throw new Exception("Debe ingresar el costo de ingreso");
		}
		
		if (inventario.getFecha() == null) {
			throw new Exception("Debe ingresar la fecha");
		}
		
		if (inventario.getCostoIngreso() == null) {
			throw new Exception("Debe ingresar el costo de ingreso");
		}
		
		Inventario inventarioEdit = getInventario(inventario.getNroInventario());
		inventarioEdit.setFecha(inventario.getFecha());
		inventarioEdit.setCostoIngreso(inventario.getCostoIngreso());
		
		return inventarioRepository.save(inventarioEdit);
	}
	
	public void eliminar(Integer idCategoria) {
		inventarioRepository.deleteById(idCategoria);
	}
	
	public Inventario getInventario(Integer nroInventario) throws Exception {
		Optional<Inventario> optInventario = inventarioRepository.findById(nroInventario);
		
		if (optInventario.isEmpty()) {
			throw new Exception("El inventario con Nro de Inventario: " + nroInventario + " no existe");
		}
		
		return optInventario.get();
	}
	
	public List<Inventario> getAll() {
		return inventarioRepository.findAll();
	}
	
}
