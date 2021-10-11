package com.mintic.mintienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	/*
	 Descripcion de la clase detalle_venta
	 
	 codigo_detalle	 
	 codigo_venta_detalle
	 codigo_prod_detalle
	 cantidad_producto
	 valor_venta
	 valor_total
	 valor_iva
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo_detalle;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_venta")
	private Venta codigo_venta_detalle;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_producto")
	private Producto codigo_prod_detalle;
	
	private Long cantidad_producto;
	
	private double valor_venta;
	
	private double valor_total;
	
	private double valor_iva;

	public Venta getCodigo_venta_detalle() {
		return codigo_venta_detalle;
	}

	public void setCodigo_venta_detalle(Venta codigo_venta_detalle) {
		this.codigo_venta_detalle = codigo_venta_detalle;
	}

	public Producto getCodigo_prod_detalle() {
		return codigo_prod_detalle;
	}

	public void setCodigo_prod_detalle(Producto codigo_prod_detalle) {
		this.codigo_prod_detalle = codigo_prod_detalle;
	}

	public Long getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
	
}
