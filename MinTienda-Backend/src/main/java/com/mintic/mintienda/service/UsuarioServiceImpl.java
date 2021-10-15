package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.UsuarioDao;
import com.mintic.mintienda.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(String id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findByTipo(Character tipoUsuario) {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		
		usuario.setTipo_usuario(tipoUsuario);
		
		Example <Usuario> usuarioEjemplo = Example.of(usuario);
		
		return usuarioDao.findAll(usuarioEjemplo);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub

		usuarioDao.deleteById(id);
	}

	@Override
	public int cuentaUsuariosActivos() {
		// TODO Auto-generated method stub
		
		return usuarioDao.cuentaUsuariosActivos();
	}

	@Override
	public int login(Usuario usuario) {
		
		return usuarioDao.findByNombreUsuarioAndPassword(usuario.getLogin_usuario(), usuario.getContrasena_usuario());
	}
}
