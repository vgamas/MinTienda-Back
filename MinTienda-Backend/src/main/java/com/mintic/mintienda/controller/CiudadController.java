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

import com.mintic.mintienda.model.Ciudad;
import com.mintic.mintienda.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;
	
	// Crear una ciudad
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Ciudad ciudad) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(ciudad));
	}

	// Buscar una ciudad por su codigo
	@GetMapping
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer ciudadId) {
		Optional<Ciudad> oCiudad = ciudadService.findById(ciudadId); 
		
		if (!oCiudad.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oCiudad);
	}
	

	// Actualizar el nombre de la ciudad
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Ciudad ciudad, @PathVariable(value = "id") Integer ciudadId) {
		Optional<Ciudad> oCiudad = ciudadService.findById(ciudadId); 
		
		if (!oCiudad.isPresent())
			return ResponseEntity.notFound().build();

		oCiudad.get().setNombre_ciudad(ciudad.getNombre_ciudad());
	
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(oCiudad.get()));
	}

	// Borrar una ciudad
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer ciudadId) {
		Optional<Ciudad> oCiudad = ciudadService.findById(ciudadId); 
		
		if (!oCiudad.isPresent())
			return ResponseEntity.notFound().build();

		ciudadService.deleteById(ciudadId);
		
		return ResponseEntity.ok(oCiudad);
	}

	// Listar todas las ciudades
	@GetMapping
	public List<Ciudad> readAll() {
		List<Ciudad> listaCiudades = StreamSupport.stream(ciudadService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaCiudades;
	}
}
