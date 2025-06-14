package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Categoria;
import com.cibertec.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired // para instanciar una clase
	private CategoriaRepository categoriaRepository;

	public Categoria crear(Categoria categoria) throws Exception {
		if (categoria.getDescripcion() == null) {
			throw new Exception("Debe ingresar una descripción");
		}

		if (categoria.getFrecuenciaComprar() == null) {
			throw new Exception("Debe ingrear la frecuencia de compra");
		}

		return categoriaRepository.save(categoria);
	}

	public Categoria editar(Categoria categoria) throws Exception {
		if (categoria.getDescripcion() == null) {
			throw new Exception("Debe ingresar una descripción");
		}

		if (categoria.getFrecuenciaComprar() == null) {
			throw new Exception("Debe ingrear la frecuencia de compra");
		}
		Categoria categoriaEdit = getCategoria(categoria.getIdCate());
		categoriaEdit.setDescripcion(categoria.getDescripcion());
		categoriaEdit.setFrecuenciaComprar(categoria.getFrecuenciaComprar());

		return categoriaRepository.save(categoriaEdit);
	}

	public void eliminar(Integer idCategoria) {
		categoriaRepository.deleteById(idCategoria);

	}

	public Categoria getCategoria(Integer idCategoria) throws Exception {
		Optional<Categoria> optCategoria = categoriaRepository.findById(idCategoria);
		if (optCategoria.isEmpty()) {
			throw new Exception("La categoria con ID: " + idCategoria + "No existe");
		}
		return optCategoria.get();
	}

	public List<Categoria> getAll() {
		return categoriaRepository.findAll(); // trae todos las categorias
	}

}
