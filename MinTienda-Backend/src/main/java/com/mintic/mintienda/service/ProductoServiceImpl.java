package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.ProductoDao;
import com.mintic.mintienda.model.Categoria;
import com.mintic.mintienda.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAllByCategoria(Integer categoria) {
		// TODO Auto-generated method stub
		
		return productoDao.listarPorCategoria(categoria);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		productoDao.deleteById(id);
	}
}
