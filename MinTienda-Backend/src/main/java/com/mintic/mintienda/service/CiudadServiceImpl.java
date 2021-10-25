package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.CiudadDao;
import com.mintic.mintienda.model.Ciudad;
import com.mintic.mintienda.model.Departamento;
import com.mintic.mintienda.model.LlaveCiudad;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadDao ciudadDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Ciudad> findAll() {
		// TODO Auto-generated method stub
		return ciudadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Ciudad> findById(LlaveCiudad id) {
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
	public void deleteById(LlaveCiudad id) {
		// TODO Auto-generated method stub
		
		ciudadDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Ciudad> FindAllByDepartamento(String departamento) {
		// TODO Auto-generated method stub
		Departamento dpto = new Departamento();
		LlaveCiudad llaveCiudad = new LlaveCiudad();
		Ciudad ciudad = new Ciudad();

		dpto.setCodigo_departamento(departamento);

		llaveCiudad.setCodigo_dpto_ciudad(dpto);

		ciudad.setId_ciudad(llaveCiudad);
		
		Example<Ciudad> ciudadEjemplo = Example.of(ciudad);
		
		return ciudadDao.findAll(ciudadEjemplo);
	}

}
