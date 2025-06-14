package com.cibertec.controller;

import java.net.ResponseCache;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Productos;
import com.cibertec.repository.InventarioRepository;
import com.cibertec.service.ProductosService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final InventarioRepository inventarioRepository;
	
	@Autowired
	private ProductosService productoService;

    ProductoController(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }
	
	@GetMapping
	public List<Productos> listarTodos(){
		return productoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Productos> obtenerPorId(@PathVariable Integer id) throws Exception{
		Productos producto = productoService.getProductos(id);
		
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping
	public Productos crearProductos(@RequestBody Productos producto) throws Exception {
		return productoService.crear(producto);
	}
	
	public ResponseEntity<Productos> editarProducto(@PathVariable Integer id, @RequestBody Productos productoDetalle) throws Exception{
		Productos productoActualizado = productoService.editar(productoDetalle);
		return ResponseEntity.noContent().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
		productoService.eliminar(id);
		return ResponseEntity.noContent().build();	
	}
	

}
