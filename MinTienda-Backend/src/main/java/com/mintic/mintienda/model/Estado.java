package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {

	/*
	 Estado de los usuarios, clientes, proveedores
	 
	 codigo_estado
	 descripcion_estado
	 */
	
	@Id
	@Column(nullable = false, unique = true)
	private Character codigo_estado;
	
	@Column(nullable = false, unique = true, length = 50)
	private String descripcion_estado;

	// Metodos de la clase
	
	public Character getCodigo_estado() {
		return codigo_estado;
	}

	public void setCodigo_estado(Character codigo_estado) {
		this.codigo_estado = codigo_estado;
	}

	public String getDescripcion_estado() {
		return descripcion_estado;
	}

	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}
}
