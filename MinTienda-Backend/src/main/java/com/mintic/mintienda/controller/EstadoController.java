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

import com.mintic.mintienda.model.Estado;
import com.mintic.mintienda.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	// Crear una estado
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Estado estado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estado));
	}
	
	// Buscar una estado por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Character estadoId) {
		Optional<Estado> oEstado = estadoService.findById(estadoId); 
		
		if (!oEstado.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oEstado);
	}
	
	// Actualizar informacion de la estado
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Estado estado, @PathVariable(value = "id") Character estadoId) {

		Optional<Estado> oEstado = estadoService.findById(estadoId); 
		
		if (!oEstado.isPresent())
			return ResponseEntity.notFound().build();

		oEstado.get().setDescripcion_estado(estado.getDescripcion_estado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(oEstado.get()));
	}
	
	// Borrar una estado
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Character estadoId) {
		
		if (!estadoService.findById(estadoId).isPresent())
			return ResponseEntity.notFound().build();
		
		estadoService.deleteById(estadoId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las estados
	@GetMapping
	public List<Estado> readAll() {
		List<Estado> listaEstados = StreamSupport.stream(estadoService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaEstados;
	}

}
