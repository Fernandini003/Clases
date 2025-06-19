package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	List<Categoria> findByDescripcionOrderByDescripcionDesc(String descripcion);

}
