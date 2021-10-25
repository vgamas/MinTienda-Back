package com.mintic.mintienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.DetalleVenta;

@Repository
public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Long> {

	@Query(value = "SELECT * FROM detalle_venta WHERE codigo_venta_detalle_codigo_venta = :venta", nativeQuery = true)
	public List<DetalleVenta> ListarPorVenta(Long venta);
}
