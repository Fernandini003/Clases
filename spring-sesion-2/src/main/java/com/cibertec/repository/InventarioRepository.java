package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}
