package com.cibertec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCate;
	private String descripcion;
	private Integer frecuenciaCompra;

	public Categoria() {
		super();
	}

	public Integer getIdCate() {
		return idCate;
	}

	public void setIdCate(Integer idCate) {
		this.idCate = idCate;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getFrecuenciaCompra() {
		return frecuenciaCompra;
	}

	public void setFrecuenciaCompra(Integer frecuenciaCompra) {
		this.frecuenciaCompra = frecuenciaCompra;
	}

	@Override
	public String toString() {
		return "Categoria [idCate=" + idCate + ", descripcion=" + descripcion + ", frecuenciaCompra=" + frecuenciaCompra
				+ "]";
	}

}
