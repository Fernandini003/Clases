package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
										   //aqui ti enitdad class, tipo de dato de la PK
	//esta interface ayudara a acceder la base de datos
}
