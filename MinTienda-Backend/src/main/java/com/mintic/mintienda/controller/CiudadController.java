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
import com.mintic.mintienda.model.Departamento;
import com.mintic.mintienda.model.LlaveCiudad;
import com.mintic.mintienda.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;
	
	// Crear una ciudad validar que no exista?
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Ciudad ciudad) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(ciudad));
	}

	// Buscar una ciudad por su codigo
	@GetMapping("/consulta")
	public ResponseEntity<?> read(String dpto, String id_ciudad) {

		LlaveCiudad ciudadId = new LlaveCiudad();
		Departamento cod_dpto = new Departamento();
		
		cod_dpto.setCodigo_departamento(dpto);
		                
		ciudadId.setCodigo_ciudad(id_ciudad);
		ciudadId.setCodigo_dpto_ciudad(cod_dpto);
		
		Optional<Ciudad> oCiudad = ciudadService.findById(ciudadId); 
		
		if (!oCiudad.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oCiudad);
	}
	

	// Actualizar el nombre de la ciudad
	@PutMapping("/actualiza")
	public ResponseEntity<?> update(@RequestBody Ciudad ciudad, String dpto, String id_ciudad) {

		LlaveCiudad ciudadId = new LlaveCiudad();
		Departamento cod_dpto = new Departamento();
		
		cod_dpto.setCodigo_departamento(dpto);
		                
		ciudadId.setCodigo_ciudad(id_ciudad);
		ciudadId.setCodigo_dpto_ciudad(cod_dpto);
		
		Optional<Ciudad> oCiudad = ciudadService.findById(ciudadId); 
		
		if (!oCiudad.isPresent())
			return ResponseEntity.notFound().build();

		oCiudad.get().setNombre_ciudad(ciudad.getNombre_ciudad());
	
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(oCiudad.get()));
	}

	// Borrar una ciudad
	@DeleteMapping("/borrar")
	public ResponseEntity<?> delete(String dpto, String id_ciudad) {

		LlaveCiudad ciudadId = new LlaveCiudad();
		Departamento cod_dpto = new Departamento();
		
		cod_dpto.setCodigo_departamento(dpto);
		                
		ciudadId.setCodigo_ciudad(id_ciudad);
		ciudadId.setCodigo_dpto_ciudad(cod_dpto);
		
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

	// Listar todas las ciudades de un departamento
	@GetMapping("/dpto/{dpto}")
	public List<Ciudad> readAll(@PathVariable(value = "dpto") String departamento) {
		List<Ciudad> listaCiudades = StreamSupport.stream(ciudadService.FindAllByDepartamento(departamento).spliterator(), false).collect(Collectors.toList());
		
		return listaCiudades;
	}
}
