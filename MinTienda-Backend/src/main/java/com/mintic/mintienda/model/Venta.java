package com.mintic.mintienda.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	/*
	   Campos de la clase venta
	   
	   codigo_venta
	   login_usr_venta
	   cliente_venta
	   fecha_venta
	   valor_venta
	   iva_venta
	   total_venta
	   estado
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo_venta;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "login_usuario")
	private Usuario login_usr_venta;

	@ManyToOne(optional = false)
	private Cliente cliente_venta;
	
	private LocalDate fecha_venta;
	
	private double valor_venta;
	
	private double iva_venta;
	
	private double total_venta;

	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_estado")
	private Estado estado_venta;
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Usuario getLogin_usr_venta() {
		return login_usr_venta;
	}

	public void setLogin_usr_venta(Usuario login_usr_venta) {
		this.login_usr_venta = login_usr_venta;
	}

	public Cliente getCliente_venta() {
		return cliente_venta;
	}

	public void setCliente_venta(Cliente cliente_venta) {
		this.cliente_venta = cliente_venta;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public Estado getEstado_venta() {
		return estado_venta;
	}

	public void setEstado_venta(Estado estado_venta) {
		this.estado_venta = estado_venta;
	}
	
}
