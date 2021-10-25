package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/* Definicion de los atributos de la clase

   codigo_ciudad
   codigo_dpto_ciudad
   nombre_ciudad
   foreign key (codigo_dpto_ciudad) references departamento(codigo_departamento)
*/


@Entity
@Table(name="ciudad")
public class Ciudad {

	@EmbeddedId
	private LlaveCiudad id_ciudad;
		
	@Column(nullable = false, length = 50)
	private String nombre_ciudad;

	// Metodos de la clase
	
	public LlaveCiudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(LlaveCiudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}
}
