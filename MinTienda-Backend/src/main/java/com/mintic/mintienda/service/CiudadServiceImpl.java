package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.CiudadDao;
import com.mintic.mintienda.model.Ciudad;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadDao ciudadDao;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Ciudad> findAll() {
		// TODO Auto-generated method stub
		return ciudadDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Ciudad> findById(Integer id) {
		// TODO Auto-generated method stub
		return ciudadDao.findById(id);
	}

	@Override
	@Transactional
	public Ciudad save(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadDao.save(ciudad);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		ciudadDao.deleteById(id);
	}

}
