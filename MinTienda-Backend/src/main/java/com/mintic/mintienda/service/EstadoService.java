package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Estado;

public interface EstadoService {

	public Iterable<Estado> findAll();
	
	public Optional<Estado> findById(Character id);
	
	public Estado save(Estado estado);
	
	public void deleteById(Character id);
}
