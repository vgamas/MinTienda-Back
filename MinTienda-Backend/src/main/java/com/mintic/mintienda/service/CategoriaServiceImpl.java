package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.CategoriaDao;
import com.mintic.mintienda.model.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> findById(Integer id) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id);
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categoria);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub

		categoriaDao.deleteById(id);
	}

	@Override
	public Iterable<Categoria> findByCategoriaSuperior(Integer id_categoria) {
		// TODO Auto-generated method stub
		
		Categoria categoria = new Categoria();

		categoria.setCategoria_superior(id_categoria);
		
		Example<Categoria> ejemploCategoria = Example.of(categoria);
		
		return categoriaDao.findAll(ejemploCategoria);
	}
}
