package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.ClienteDao;
import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.LlaveCliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(LlaveCliente id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(LlaveCliente id) {
		// TODO Auto-generated method stub
		
		clienteDao.deleteById(id);
	}

}
