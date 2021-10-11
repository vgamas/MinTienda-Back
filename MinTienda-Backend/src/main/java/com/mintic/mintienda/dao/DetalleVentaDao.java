package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.DetalleVenta;

@Repository
public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Long> {

}
