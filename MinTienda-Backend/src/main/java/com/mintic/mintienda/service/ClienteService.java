package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.LlaveCliente;

public interface ClienteService {

	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(LlaveCliente id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(LlaveCliente id);
}
