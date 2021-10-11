package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Venta;

@Repository
public interface VentaDao extends JpaRepository<Venta, Long> {

}
