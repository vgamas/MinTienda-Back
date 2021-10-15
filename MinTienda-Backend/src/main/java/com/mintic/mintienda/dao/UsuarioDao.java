package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String> {
	
	// Validar el login, que el usuario y el password correspondan con un usuario ACTIVO
	@Query("select count(*) from usuario as u where u.login_usuario= :nombreUsuario and p.contasena_usuario=:password and u.estado_usuario = 'A'")
	Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);
	
	//Contar usuarios activos
	@Query("select count(*) from usuario as u where u.estado_usuario = 'A'")
	Integer cuentaUsuariosActivos();
}
