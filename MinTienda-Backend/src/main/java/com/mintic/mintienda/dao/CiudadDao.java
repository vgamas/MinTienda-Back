package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Ciudad;
import com.mintic.mintienda.model.LlaveCiudad;

@Repository
public interface CiudadDao extends JpaRepository<Ciudad, LlaveCiudad> {

}
