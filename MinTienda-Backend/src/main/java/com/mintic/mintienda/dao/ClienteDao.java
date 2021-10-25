package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.LlaveCliente;

@Repository
@Transactional
public interface ClienteDao extends JpaRepository<Cliente, LlaveCliente> {

	
	@Query(value = "SELECT tipo_doc_cliente_codigo_tipo as 'tipo_documento', documento_cliente as numero_documento, nombre_cliente as nombre_cliente "
			+ "FROM cliente WHERE estado_cliente_codigo_estado = 'A'", nativeQuery = true)
	public Iterable<?> ListarResumenClientes();

}
