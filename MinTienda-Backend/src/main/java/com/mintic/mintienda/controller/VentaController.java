package com.mintic.mintienda.controller;

import java.sql.Date;
import java.time.LocalDate;
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

import com.mintic.mintienda.model.Venta;
import com.mintic.mintienda.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	// Crear una venta
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Venta venta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta));
	}
	
	// Buscar una venta por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long ventaId) {
		Optional<Venta> oVenta = ventaService.findById(ventaId); 
		
		if (!oVenta.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oVenta);
	}
	
	// Actualizar informacion de la venta
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Venta venta, @PathVariable(value = "id") Long ventaId) {

		Optional<Venta> oVenta = ventaService.findById(ventaId); 
		
		if (!oVenta.isPresent())
			return ResponseEntity.notFound().build();

		oVenta.get().setLogin_usr_venta(venta.getLogin_usr_venta());
		oVenta.get().setCliente_venta(venta.getCliente_venta());
		oVenta.get().setFecha_venta(venta.getFecha_venta());
		oVenta.get().setValor_venta(venta.getValor_venta());
		oVenta.get().setIva_venta(venta.getIva_venta());
		oVenta.get().setTotal_venta(venta.getTotal_venta());
		oVenta.get().setEstado_venta(venta.getEstado_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(oVenta.get()));
	}
	
	// Borrar una venta
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long ventaId) {
		
		if (!ventaService.findById(ventaId).isPresent())
			return ResponseEntity.notFound().build();
		
		ventaService.deleteById(ventaId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las ventas
	@GetMapping
	public List<Venta> readAll() {
		List<Venta> listaVentas = StreamSupport.stream(ventaService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaVentas;
	}
	
	// Listar las ventas de una fecha
	// Listar todas las ventas
	@GetMapping("/fecha")
	public List<Venta> readAllByDate(String fechaStr) {
		
		LocalDate fecha;
		
		fecha = LocalDate.parse(fechaStr);
		
		List<Venta> listaVentas = StreamSupport.stream(ventaService.findByFecha(fecha).spliterator(), false).collect(Collectors.toList());
		
		return listaVentas;
	}
}
