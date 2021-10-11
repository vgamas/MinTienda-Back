package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.EstadoDao;
import com.mintic.mintienda.model.Estado;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoDao estadoDao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Estado> findAll() {
		// TODO Auto-generated method stub
		return estadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Estado> findById(Character id) {
		// TODO Auto-generated method stub
		return estadoDao.findById(id);
	}

	@Override
	@Transactional
	public Estado save(Estado estado) {
		// TODO Auto-generated method stub
		return estadoDao.save(estado);
	}

	@Override
	public void deleteById(Character id) {
		// TODO Auto-generated method stub

		estadoDao.deleteById(id);
	}

}
