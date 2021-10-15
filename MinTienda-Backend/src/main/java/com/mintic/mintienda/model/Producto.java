package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
   Estructura de la clase producto
   codigo_producto
   categoria_producto
   nombre_producto
   proveedor_producto
   precio_compra
   iva_compra
   precio_venta
 */

@Entity
@Table(name  = "producto")
public class Producto {

	@Id
	@Column(unique = true, nullable = false)
	private Long codigo_producto;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_categoria")
	private Categoria categoria_producto;

	@Column(nullable = false, length = 50)
	private String nombre_producto;
	
	@ManyToOne(optional = false)
//	@JoinColumn(referencedColumnName = "tipo_doc_proveedor")
//	@JoinColumn(referencedColumnName = "documento_proveedor")
	private Proveedor proveedor_producto;
	
	private double precio_compra;
	
	private double iva_compra;
	
	private double precio_venta;

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Categoria getCategoria_producto() {
		return categoria_producto;
	}

	public void setCategoria_producto(Categoria categoria_producto) {
		this.categoria_producto = categoria_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Proveedor getProveedor_producto() {
		return proveedor_producto;
	}

	public void setProveedor_producto(Proveedor proveedor_producto) {
		this.proveedor_producto = proveedor_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getIva_compra() {
		return iva_compra;
	}

	public void setIva_compra(double iva_compra) {
		this.iva_compra = iva_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_Venta) {
		this.precio_venta = precio_Venta;
	}
}
