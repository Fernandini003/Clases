
package com.cibertec.entity;

import java.util.Objects;

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
	private String nomProducto;
	private Double stockActual;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idCate")
	private Categoria categoria;

	public Productos() {
		super();
	}

	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public Double getStockActual() {
		return stockActual;
	}

	public void setStockActual(Double stockActual) {
		this.stockActual = stockActual;
	}

	@Override
	public String toString() {
		return "Productos [idProd=" + idProd + ", nomProducto=" + nomProducto + ", stockActual=" + stockActual
				+ ", categoria=" + categoria + "]";
	}

}