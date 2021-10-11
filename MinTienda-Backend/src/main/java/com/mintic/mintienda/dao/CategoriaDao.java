package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {

}
