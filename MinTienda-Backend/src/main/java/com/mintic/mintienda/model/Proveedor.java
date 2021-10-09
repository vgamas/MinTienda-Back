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
   Descripcion de la clase Proveedor
   
   Llave compuesta
   tipo_doc_proveedor
   documento_proveedor
   
   nombre_proveedor
   direccion_proveedor
   ciudad_proveedor
   telefono_proveedor
   correo_proveedor
   estado_proveedor
  */

final class LlaveProveedor implements Serializable {
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_tipo")
	private TipoDocumento tipo_doc_proveedor;

	@Column(nullable = false)
	private Long documento_proveedor;
}

@Entity
@Table(name = "proveedor")
@IdClass(value = LlaveProveedor.class)
public class Proveedor {

	@Id
	private TipoDocumento tipo_doc_proveedor;
	
	@Id
	private Long documento_proveedor;
	
	@Column(nullable = false, length = 50)
	private String nombre_proveedor;
	
	@Column(nullable = false, length = 100)
	private String direccion_proveedor;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_ciudad")
	private Ciudad ciudad_proveedor;
	
	@Column(length=10)
	private String telefono_proveedor;
	
	@Column(nullable = false, length = 50)
	private String correo_proveedor;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_estado")
	private Estado estado_proveedor;

	public TipoDocumento getTipo_doc_proveedor() {
		return tipo_doc_proveedor;
	}

	public void setTipo_doc_proveedor(TipoDocumento tipo_doc_proveedor) {
		this.tipo_doc_proveedor = tipo_doc_proveedor;
	}

	public Long getDocumento_proveedor() {
		return documento_proveedor;
	}

	public void setDocumento_proveedor(Long documento_proveedor) {
		this.documento_proveedor = documento_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public Ciudad getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(Ciudad ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getCorreo_proveedor() {
		return correo_proveedor;
	}

	public void setCorreo_proveedor(String correo_proveedor) {
		this.correo_proveedor = correo_proveedor;
	}

	public Estado getEstado_proveedor() {
		return estado_proveedor;
	}

	public void setEstado_proveedor(Estado estado_proveedor) {
		this.estado_proveedor = estado_proveedor;
	}
}
