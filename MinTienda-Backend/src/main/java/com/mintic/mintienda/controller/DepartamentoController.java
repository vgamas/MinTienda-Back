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

import com.mintic.mintienda.model.Departamento;
import com.mintic.mintienda.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	// Crear una departamento
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Departamento departamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.save(departamento));
	}
	
	// Buscar una departamento por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") String departamentoId) {
		Optional<Departamento> oDepartamento = departamentoService.findById(departamentoId); 
		
		if (!oDepartamento.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oDepartamento);
	}
	
	// Actualizar informacion de la departamento
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Departamento departamento, @PathVariable(value = "id") String departamentoId) {

		Optional<Departamento> oDepartamento = departamentoService.findById(departamentoId); 
		
		if (!oDepartamento.isPresent())
			return ResponseEntity.notFound().build();

		oDepartamento.get().setNombre_departamento(departamento.getNombre_departamento());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.save(oDepartamento.get()));
	}
	
	// Borrar una departamento
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String departamentoId) {
		
		if (!departamentoService.findById(departamentoId).isPresent())
			return ResponseEntity.notFound().build();
		
		departamentoService.delete(departamentoId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las departamentos
	@GetMapping
	public List<Departamento> readAll() {
		List<Departamento> listaDepartamentos = StreamSupport.stream(departamentoService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaDepartamentos;
	}

}
