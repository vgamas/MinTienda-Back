package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Ciudad;

public interface CiudadService {

	public Iterable<Ciudad> findAll();
	
	public Optional<Ciudad> findById(Integer id);
	
	public Ciudad save(Ciudad ciudad);
	
	public void deleteById(Integer id);
	
	// buscar ciudades por departamento
//	public Iterable<Ciudad> FindAllByDepartamento(Integer departamento);
}
