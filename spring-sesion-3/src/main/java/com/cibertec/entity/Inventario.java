package com.cibertec.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@Column(name = "costo_ingresos")
	private Double costoIngreso;


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


	public Double getCostoIngreso() {
		return costoIngreso;
	}

	public void setCostoIngreso(Double costoIngreso) {
		this.costoIngreso = costoIngreso;
	}

	@Override
	public String toString() {
		return "Inventario [nroInventario=" + nroInventario + ", fecha=" + fecha + ", costoIngreso=" + costoIngreso + "]";
	}

}
