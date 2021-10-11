package com.mintic.mintienda.service;

import java.time.LocalDate;
import java.util.Optional;

import com.mintic.mintienda.model.LlaveCliente;
import com.mintic.mintienda.model.Usuario;
import com.mintic.mintienda.model.Venta;

public interface VentaService {

	public Iterable<Venta> findAll();
	
	public Optional<Venta> findById(Long id);
	
	public Iterable<Venta> findByCliente(LlaveCliente llaveCliente);
	
	public Iterable<Venta> findByFecha(LocalDate fecha);

	public Iterable<Venta> findByUsuario(Usuario usuario);

	public Venta save(Venta venta);
	
	public void deleteById(Long id);
}
