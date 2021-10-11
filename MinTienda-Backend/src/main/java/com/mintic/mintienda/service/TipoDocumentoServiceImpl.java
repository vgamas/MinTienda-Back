package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.TipoDocumentoDao;
import com.mintic.mintienda.model.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoDocumento> findAll() {
		// TODO Auto-generated method stub
		return tipoDocumentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoDocumento> findById(String id) {
		// TODO Auto-generated method stub
		return tipoDocumentoDao.findById(id);
	}

	@Override
	@Transactional
	public TipoDocumento save(TipoDocumento tipoDocumento) {
		// TODO Auto-generated method stub
		return tipoDocumentoDao.save(tipoDocumento);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub

		tipoDocumentoDao.deleteById(id);
	}

}
