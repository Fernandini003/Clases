package com.cibertec.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroInventario;
	private Date fecha;
	private Double costoIngresos;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "idProd")
	private Productos producto;
	
	public Inventario() {
		super();
	}

	public Integer getNroInventario() {
		return nroInventario;
	}

	public void setNroInventario(Integer nroInventario) {
		this.nroInventario = nroInventario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getCostoIngresos() {
		return costoIngresos;
	}

	public void setCostoIngresos(Double costoIngresos) {
		this.costoIngresos = costoIngresos;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Inventario [nroInventario=" + nroInventario + ", fecha=" + fecha + ", costoIngresos=" + costoIngresos
				+ ", producto=" + producto + "]";
	}


	
	
	
	
}
