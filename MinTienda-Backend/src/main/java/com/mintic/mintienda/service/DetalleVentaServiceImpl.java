package com.mintic.mintienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.mintienda.dao.DetalleVentaDao;
import com.mintic.mintienda.model.DetalleVenta;
import com.mintic.mintienda.model.Venta;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Autowired
	private DetalleVentaDao detalleVentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<DetalleVenta> findAllByVenta(Long venta) {
		// TODO Auto-generated method stub

		Venta ventaActual = new Venta();
		DetalleVenta detalle = new DetalleVenta();
		
		ventaActual.setCodigo_venta(venta);
		detalle.setCodigo_venta_detalle(ventaActual);

		Example<DetalleVenta> detalleEjemplo = Example.of(detalle);
		
		return detalleVentaDao.findAll(detalleEjemplo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleVenta> findById(Long id) {
		// TODO Auto-generated method stub
		return detalleVentaDao.findById(id);
	}

	@Override
	@Transactional
	public DetalleVenta save(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		return detalleVentaDao.save(detalleVenta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		detalleVentaDao.deleteById(id);
	}

}
