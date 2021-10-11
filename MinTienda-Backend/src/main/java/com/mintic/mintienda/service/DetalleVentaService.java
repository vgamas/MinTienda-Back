package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.DetalleVenta;

public interface DetalleVentaService {

	public Iterable<DetalleVenta> findAllByVenta(Long venta);
	
	public Optional<DetalleVenta> findById(Long id);
	
	public DetalleVenta save(DetalleVenta detalleVenta);
	
	public void deleteById(Long id);
}
