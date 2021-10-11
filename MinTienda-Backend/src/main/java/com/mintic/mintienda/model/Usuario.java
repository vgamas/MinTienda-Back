package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	/* Estructura de la clase
	 login_usuario
	 tipo_doc_usuario
	 documento_usuario
	 nombre_usuario
	 correo_usuario
	 contrasena_usuario
	 estado_usuario
	 tipo_usuario
	 */
	
	@Id
	@Column(nullable = false, unique = true, length=20)
	private String login_usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, referencedColumnName="codigo_tipo")
	private TipoDocumento tipo_doc_usuario;

	@Column(nullable = false)
	private Long documento_usuario;
	
	@Column(nullable = false, length = 50)
	private String nombre_usuario;
	
	@Column(nullable = false, unique = true, length = 50)
	private String correo_usuario;
	
	@Column(nullable = false)
	private String contrasena_usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName="codigo_estado")
	private Estado estado_usuario;

//	@Column(columnDefinition="enum('ADMINISTRADOR','USUARIO','CLIENTE', 'PROVEEDOR')", nullable = false)
	@Column(nullable = false)
	private Character tipo_usuario;

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}

	public TipoDocumento getTipo_doc_usuario() {
		return tipo_doc_usuario;
	}

	public void setTipo_doc_usuario(TipoDocumento tipo_doc_usuario) {
		this.tipo_doc_usuario = tipo_doc_usuario;
	}

	public Long getDocumento_usuario() {
		return documento_usuario;
	}

	public void setDocumento_usuario(Long documento_usuario) {
		this.documento_usuario = documento_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo_usuario() {
		return correo_usuario;
	}

	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}

	public String getContrasena_usuario() {
		return contrasena_usuario;
	}

	public void setContrasena_usuario(String contrasena_usuario) {
		this.contrasena_usuario = contrasena_usuario;
	}

	public Estado getEstado_usuario() {
		return estado_usuario;
	}

	public void setEstado_usuario(Estado estado_usuario) {
		this.estado_usuario = estado_usuario;
	}

	public char getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(char tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
}
