package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {

	/*
	 Definicion de los campos de la tabla departamento
	 
	 codigo_departamento
	 nombre_departamento
	 */
	
	@Id
	@Column(nullable = false, unique = true)
	private Integer codigo_departamento;
	
	@Column(nullable = false, length = 50)
	private String nombre_departamento;

	// Metodos de la clase

	public Integer getCodigo_departamento() {
		return codigo_departamento;
	}

	public void setCodigo_departamento(Integer codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}	
}
