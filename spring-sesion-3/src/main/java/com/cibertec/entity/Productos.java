package com.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProd;
	@Column(name = "nom_producto") 
	private String nomProd;
	private Integer stockActual;
	
	public Productos() {
		super();
	}

	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}


	public String getNomProd() {
		return nomProd;
	}


	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}


	public Integer getStockActual() {
		return stockActual;
	}


	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}


	@Override
	public String toString() {
		return "Productos [idProd=" + idProd + ", nomProd=" + nomProd + ", stockActual=" + stockActual + "]";
	}

}
