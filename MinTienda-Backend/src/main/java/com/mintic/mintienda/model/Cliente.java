package com.mintic.mintienda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
   Estructura de la clase Clientes
   
   Llave compuesta
   tipo_doc_cliente
   documento_cliente
   
   nombre_cliente
   direccion_cliente
   ciudad_cliente
   telefono_cliente
   correo_cliente
   estado_cliente
 */

final class LlaveCliente implements Serializable {
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_tipo")
	private TipoDocumento tipo_doc_cliente;

	@Column(nullable = false)
	private Long documento_cliente;
}

@Entity
@Table(name = "cliente")
@IdClass(value = LlaveCliente.class)
public class Cliente {

	@Id
	private TipoDocumento tipo_doc_cliente;
	
	@Id
	private Long documento_cliente;
	
	@Column(nullable = false, length = 50)
	private String nombre_cliente;
	
	@Column(nullable = false, length = 100)
	private String direccion_cliente;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_ciudad")
	private Ciudad ciudad_cliente;
	
	@Column(length=10)
	private String telefono_cliente;
	
	@Column(nullable = false, length = 50)
	private String correo_cliente;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_estado")
	private Estado estado_cliente;

	public TipoDocumento getTipo_doc_cliente() {
		return tipo_doc_cliente;
	}

	public void setTipo_doc_cliente(TipoDocumento tipo_doc_cliente) {
		this.tipo_doc_cliente = tipo_doc_cliente;
	}

	public Long getDocumento_cliente() {
		return documento_cliente;
	}

	public void setDocumento_cliente(Long documento_cliente) {
		this.documento_cliente = documento_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public Ciudad getCiudad_cliente() {
		return ciudad_cliente;
	}

	public void setCiudad_cliente(Ciudad ciudad_cliente) {
		this.ciudad_cliente = ciudad_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}

	public Estado getEstado_cliente() {
		return estado_cliente;
	}

	public void setEstado_cliente(Estado estado_cliente) {
		this.estado_cliente = estado_cliente;
	}
}