package com.mintic.mintienda.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Venta;

@Repository
public interface VentaDao extends JpaRepository<Venta, Long> {

	@Query(value = "SELECT * FROM VENTA WHERE FECHA_VENTA = :fecha", nativeQuery = true)
	public List<Venta> listarPorFecha(LocalDate fecha);
}
