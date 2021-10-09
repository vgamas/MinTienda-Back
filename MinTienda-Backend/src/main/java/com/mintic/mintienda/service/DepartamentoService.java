package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Departamento;

public interface DepartamentoService {

	public Iterable<Departamento> findAll();
	
	public Optional<Departamento> findById(Integer id);
	
	public Departamento save(Departamento departamento);
	
	public void delete(Integer id);
}
