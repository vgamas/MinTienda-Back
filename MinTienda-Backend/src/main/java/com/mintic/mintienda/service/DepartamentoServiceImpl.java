package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.DepartamentoDao;
import com.mintic.mintienda.model.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Departamento> findAll() {
		// TODO Auto-generated method stub
		return departamentoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Departamento> findById(Integer id) {
		// TODO Auto-generated method stub
		return departamentoDao.findById(id);
	}

	@Override
	@Transactional
	public Departamento save(Departamento departamento) {
		// TODO Auto-generated method stub
		return departamentoDao.save(departamento);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		departamentoDao.deleteById(id);
	}

}
