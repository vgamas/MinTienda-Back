package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.LlaveProveedor;
import com.mintic.mintienda.model.Proveedor;

public interface ProveedorService {
	
	public Iterable<Proveedor> findAll();
	
	public Optional<Proveedor> findById(LlaveProveedor id);
	
	public Proveedor save(Proveedor proveedor);
	
	public void deleteById(LlaveProveedor id);

}
