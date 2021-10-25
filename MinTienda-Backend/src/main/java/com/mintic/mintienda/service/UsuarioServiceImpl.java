package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.UsuarioDao;
import com.mintic.mintienda.model.Estado;
import com.mintic.mintienda.model.TipoDocumento;
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
	public Iterable<Usuario> findByTipo(String tipoUsuario) {
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
	public long cuentaUsuariosActivos() {
		// TODO Auto-generated method stub
		Estado estado = new Estado();
		Usuario usuario = new Usuario();

		estado.setCodigo_estado('A');
		
		usuario.setEstado_usuario(estado);
		
		Example<Usuario> usuarioEjemplo = Example.of(usuario);

		return usuarioDao.count(usuarioEjemplo);
	}

	@Override
	public Optional<Usuario> findByNombreUsuarioAndPassword(String usuario, String password) {

		Usuario usuarioLogin = new Usuario();
		
		usuarioLogin.setLogin_usuario(usuario);
		usuarioLogin.setContrasena_usuario(password);
		
		Example<Usuario> usuarioEjemplo = Example.of(usuarioLogin);
	
		return usuarioDao.findOne(usuarioEjemplo);
	}
	
	@Override
	public int login(Usuario usuario) {
		
/*		if (cuentaUsuariosActivos() > 0)
			return findByNombreUsuarioAndPassword(usuario);
		else if (usuario.getLogin_usuario().equals("admininicial") && usuario.getContrasena_usuario().equals("admin12345"))
			return 0;
*/		
		return (-1);
	}

	@Override
	public Iterable<Usuario> findByDocumento(String tipo, Long documento) {
		// TODO Auto-generated method stub
		TipoDocumento tipoDoc = new TipoDocumento();
		
		Usuario usuario = new Usuario();
		
		tipoDoc.setCodigo_tipo(tipo);
		
		usuario.setTipo_doc_usuario(tipoDoc);
		usuario.setDocumento_usuario(documento);
				
		Example<Usuario> usuarioEjemplo = Example.of(usuario);
	
		return usuarioDao.findAll(usuarioEjemplo);
	}
}
