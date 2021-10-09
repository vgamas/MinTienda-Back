package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad {

	/* Definicion de los atributos de la clase
 
	 codigo_ciudad
	 codigo_dpto_ciudad
	 nombre_ciudad
	 foreign key (codigo_dpto_ciudad) references departamento(codigo_departamento)
	 */

	@Id
	@Column(unique = true, nullable = false)
	private Integer codigo_ciudad;
	
	// falta relacionarla con la tabla departamento por el campo codigo_departamento
	@ManyToOne(optional = false)
	@JoinColumn(name = "codigo_departamento")
	private Departamento codigo_dpto_ciudad;
	
	@Column(nullable = false, length = 50)
	private String nombre_ciudad;

	// Metodos de la clase
	
	public Integer getCodigo_ciudad() {
		return codigo_ciudad;
	}

	public void setCodigo_ciudad(Integer codigo_ciudad) {
		this.codigo_ciudad = codigo_ciudad;
	}

	public Departamento getCodigo_dpto_ciudad() {
		return codigo_dpto_ciudad;
	}

	public void setCodigo_dpto_ciudad(Departamento codigo_dpto_ciudad) {
		this.codigo_dpto_ciudad = codigo_dpto_ciudad;
	}

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}
}
