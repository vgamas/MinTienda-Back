package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Ciudad;
import com.mintic.mintienda.model.LlaveCiudad;

public interface CiudadService {

	public Iterable<Ciudad> findAll();
	
	public Optional<Ciudad> findById(LlaveCiudad id);
	
	public Ciudad save(Ciudad ciudad);
	
	public void deleteById(LlaveCiudad id);
	
	// buscar ciudades por departamento
	public Iterable<Ciudad> FindAllByDepartamento(String departamento);
}
