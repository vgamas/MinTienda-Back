package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}
