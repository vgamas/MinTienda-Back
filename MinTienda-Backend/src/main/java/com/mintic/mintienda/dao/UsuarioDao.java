package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String> {

}
