package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento {

	/*
	 Tipos de identificacion del usuario, cliente o provedor

	 codigo_tipo
	 descripcion_tipo
	 */
	
	@Id
	@Column(nullable = false, unique = true, length = 2)
	private String codigo_tipo;
	
	@Column(nullable = false, unique = true, length = 30)
	private String descripcion_tipo;

	// Metodos de la clase
	
	public String getCodigo_tipo() {
		return codigo_tipo;
	}

	public void setCodigo_tipo(String codigo_tipo) {
		this.codigo_tipo = codigo_tipo;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	public void setDescripcion_tipo(String descripcion_tipo) {
		this.descripcion_tipo = descripcion_tipo;
	}
}
