package com.mintic.mintienda.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.VentaDao;
import com.mintic.mintienda.model.LlaveCliente;
import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.Usuario;
import com.mintic.mintienda.model.Venta;

public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Venta> findById(Long id) {
		// TODO Auto-generated method stub
		return ventaDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findByCliente(LlaveCliente llaveCliente) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		Venta venta = new Venta();
		
		cliente.setDoc_cliente(llaveCliente);

		venta.setCliente_venta(cliente);
		
		Example<Venta> ventaEjemplo = Example.of(venta);
		
		return ventaDao.findAll(ventaEjemplo);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findByFecha(LocalDate fecha) {
		// TODO Auto-generated method stub

		Venta venta = new Venta();
		
		venta.setFecha_venta(fecha);

		Example<Venta> ventaEjemplo = Example.of(venta);
		
		return ventaDao.findAll(ventaEjemplo);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Venta venta = new Venta();
		
		venta.setLogin_usr_venta(usuario);

		Example<Venta> ventaEjemplo = Example.of(venta);
			
		return ventaDao.findAll(ventaEjemplo);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		// TODO Auto-generated method stub
		return ventaDao.save(venta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		ventaDao.deleteById(id);
	}

}
