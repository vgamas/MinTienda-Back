package com.mintic.mintienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.TipoDocumento;

@Repository
public interface TipoDocumentoDao extends JpaRepository<TipoDocumento, String> {

}
