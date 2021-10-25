package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Departamento;

@Repository
public interface DepartamentoDao extends JpaRepository<Departamento, String> {
	
}
