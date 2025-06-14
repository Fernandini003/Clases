package com.cibertec.entity;

import java.util.Objects;

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
	private Integer  frecuenciaComprar;
	
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
	public Integer getFrecuenciaComprar() {
		return frecuenciaComprar;
	}
	public void setFrecuenciaComprar(Integer frecuenciaComprar) {
		this.frecuenciaComprar = frecuenciaComprar;
	}
	@Override
	public String toString() {
		return "Categoria [idCate=" + idCate + ", descripcion=" + descripcion + ", frecuenciaComprar="
				+ frecuenciaComprar + "]";
	}
	

	
	
	
	
	

}
