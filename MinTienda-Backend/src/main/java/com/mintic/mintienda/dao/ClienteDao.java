package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.LlaveCliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, LlaveCliente> {

}
