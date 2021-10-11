package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.TipoDocumento;

public interface TipoDocumentoService {

	public Iterable<TipoDocumento> findAll();
	
	public Optional<TipoDocumento> findById(String id);
	
	public TipoDocumento save(TipoDocumento tipoDocumento);
	
	public void deleteById(String id);
}
