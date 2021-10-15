package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Producto;

public interface ProductoService {
	
	public Iterable<Producto> findAllByCategoria(Integer categoria);
	
	public Optional<Producto> findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
}
