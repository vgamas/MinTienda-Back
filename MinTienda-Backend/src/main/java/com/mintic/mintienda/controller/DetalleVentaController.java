package com.mintic.mintienda.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.mintienda.model.DetalleVenta;
import com.mintic.mintienda.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalle")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaService detalleVentaService;
	
	// Crear una detalleVenta
	@PostMapping
	public ResponseEntity<?> create(@RequestBody DetalleVenta detalleVenta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.save(detalleVenta));
	}
	
	// Buscar una detalleVenta por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long detalleVentaId) {
		Optional<DetalleVenta> oDetalleVenta = detalleVentaService.findById(detalleVentaId); 
		
		if (!oDetalleVenta.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oDetalleVenta);
	}
	
	// Actualizar informacion de la detalleVenta
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody DetalleVenta detalleVenta, @PathVariable(value = "id") Long detalleVentaId) {

		Optional<DetalleVenta> oDetalleVenta = detalleVentaService.findById(detalleVentaId); 
		
		if (!oDetalleVenta.isPresent())
			return ResponseEntity.notFound().build();

		oDetalleVenta.get().setCodigo_prod_detalle(detalleVenta.getCodigo_prod_detalle());
		oDetalleVenta.get().setCantidad_producto(detalleVenta.getCantidad_producto());
		oDetalleVenta.get().setValor_venta(detalleVenta.getValor_venta());
		oDetalleVenta.get().setValor_total(detalleVenta.getValor_total());
		oDetalleVenta.get().setValor_iva(detalleVenta.getValor_iva());

		return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.save(oDetalleVenta.get()));
	}
	
	// Borrar una detalleVenta
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long detalleVentaId) {
		
		if (!detalleVentaService.findById(detalleVentaId).isPresent())
			return ResponseEntity.notFound().build();
		
		detalleVentaService.deleteById(detalleVentaId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las detalleVentas
	@GetMapping
	public List<DetalleVenta> readAll(@PathVariable(value = "id") Long ventaId) {
		List<DetalleVenta> listaDetalleVentas = StreamSupport.stream(detalleVentaService.findAllByVenta(ventaId).spliterator(), false).collect(Collectors.toList());
		
		return listaDetalleVentas;
	}

}
