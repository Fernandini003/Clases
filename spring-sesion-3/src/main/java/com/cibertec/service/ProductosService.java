package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Productos;
import com.cibertec.repository.ProductosRepository;

@Service
public class ProductosService {

	@Autowired
	private ProductosRepository productosRepository;
	
	public Productos crear(Productos producto) throws Exception {
		if (producto.getNomProd() == null) {
			throw new Exception("Debe ingresar el nombre del producto");
		}
		
		if (producto.getStockActual() == null) {
			throw new Exception("Debe ingresar el stock");
		}
		
		return productosRepository.save(producto);
	}
	
	public Productos editar(Productos producto) throws Exception {
		if (producto.getNomProd() == null) {
			throw new Exception("Debe ingresar el nombre del producto");
		}
		
		if (producto.getStockActual() == null) {
			throw new Exception("Debe ingresar el stock");
		}
		
		
		Productos productoEdit = getProducto(producto.getIdProd());
		productoEdit.setNomProd(producto.getNomProd());
		productoEdit.setStockActual(producto.getStockActual());
		
		return productosRepository.save(productoEdit);
	}
	
	public void eliminar(Integer idProducto) {
		productosRepository.deleteById(idProducto);
	}
	
	public Productos getProducto(Integer idProducto) throws Exception {
		Optional<Productos> optProducto = productosRepository.findById(idProducto);
		
		if (optProducto.isEmpty()) {
			throw new Exception("El Producto con ID: " + idProducto + " no existe");
		}
		
		return optProducto.get();
	}
	
	public List<Productos> getAll() {
		return productosRepository.findAll();
	}
	
}
