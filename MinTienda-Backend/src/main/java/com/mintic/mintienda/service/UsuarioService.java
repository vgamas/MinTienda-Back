package com.mintic.mintienda.service;

import java.util.Optional;

import com.mintic.mintienda.model.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> findAll();
	
	public Optional<Usuario> findById(String id);
	
	public Iterable<Usuario> findByTipo(Character tipoUsuario);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(String id);
	
	public int cuentaUsuariosActivos();
	
	public int login(Usuario usuario);
}
