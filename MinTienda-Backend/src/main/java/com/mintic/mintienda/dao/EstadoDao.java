package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Estado;

@Repository
public interface EstadoDao extends JpaRepository<Estado, Character> {

}
