package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.ProveedorDao;
import com.mintic.mintienda.model.LlaveProveedor;
import com.mintic.mintienda.model.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return proveedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findById(LlaveProveedor id) {
		// TODO Auto-generated method stub
		return proveedorDao.findById(id);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public void deleteById(LlaveProveedor id) {
		// TODO Auto-generated method stub

		proveedorDao.deleteById(id);
	}

}
