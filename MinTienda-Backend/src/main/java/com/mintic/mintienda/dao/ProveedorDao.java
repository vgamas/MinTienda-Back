package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.LlaveProveedor;
import com.mintic.mintienda.model.Proveedor;

@Repository
public interface ProveedorDao extends JpaRepository<Proveedor, LlaveProveedor> {

}
