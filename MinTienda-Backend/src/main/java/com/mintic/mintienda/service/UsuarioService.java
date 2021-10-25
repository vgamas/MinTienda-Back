package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> findAll();
	
	public Optional<Usuario> findById(String id);
	
	public Iterable<Usuario> findByTipo(String tipoUsuario);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(String id);
	
	public long cuentaUsuariosActivos();
	
	public Optional<Usuario> findByNombreUsuarioAndPassword(String usuario, String password);

	public Iterable<Usuario> findByDocumento(String tipo, Long documento);

	public int login(Usuario usuario);
}
