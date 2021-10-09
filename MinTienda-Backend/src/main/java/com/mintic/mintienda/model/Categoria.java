package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	/* Definicion de atributos de la clase
	 codigo_categoria
	 descripcion_categoria
	 nivel_categoria
	 categoria_superior
	 */
	
	@Id
	private Integer codigo_categoria;
	
	@Column(nullable = false, length = 50)
	private String descripcion_categoria;
	
	@Column(nullable = false)
	private int nivel_categoria;
	
	private int categoria_superior;

	public Integer getCodigo_categoria() {
		return codigo_categoria;
	}

	public void setCodigo_categoria(Integer codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}

	public int getNivel_categoria() {
		return nivel_categoria;
	}

	public void setNivel_categoria(int nivel_categoria) {
		this.nivel_categoria = nivel_categoria;
	}

	public int getCategoria_superior() {
		return categoria_superior;
	}

	public void setCategoria_superior(int categoria_superior) {
		this.categoria_superior = categoria_superior;
	}
	
}
