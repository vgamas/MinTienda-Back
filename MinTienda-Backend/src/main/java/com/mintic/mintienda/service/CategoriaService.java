package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Categoria;

public interface CategoriaService {

	public Iterable<Categoria> findAll();
	
	public Optional<Categoria> findById(Integer id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(Integer id);
	
	public Iterable<Categoria> findByCategoriaSuperior(Integer id_categoria);

}
