package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Productos;
import com.cibertec.repository.ProductosRepository;

@Service // para un servicio
public class ProductosService {

	@Autowired
	private ProductosRepository productosRepository;

	public Productos crear (Productos productos) throws Exception {
		if(productos.getNomProducto()== null) {
			throw new Exception("Debe ingresar el nombre del producto");
		}
		
		if(productos.getStockActual()== null) {
			throw new Exception("Debe ingresar el stock actual");
		}
		
		return productosRepository.save(productos);

	};
	

	public Productos editar(Productos productos) throws Exception {
		if (productos.getNomProducto() == null) {
			throw new Exception("Debe ingresar el nombre del producto");
		}

		if (productos.getStockActual() == null) {
			throw new Exception("Debe ingresar el stock actual");
		}

		Productos productosEdit = getProductos(productos.getIdProd());
		productosEdit.setNomProducto(productos.getNomProducto());
		productosEdit.setStockActual(productos.getStockActual());

		return productosRepository.save(productos);
	}

	public void eliminar(Integer idProductos) {
		productosRepository.deleteById(idProductos);
	}

	public Productos getProductos(Integer idProductos) throws Exception {
		Optional<Productos> optProductos = productosRepository.findById(idProductos);
		if (optProductos.isEmpty()) {
			throw new Exception("El producto con ID: " + idProductos + "No existe");
		}
		return optProductos.get();
	}

	public List<Productos> getAll() {
		return productosRepository.findAll();
	}
}
