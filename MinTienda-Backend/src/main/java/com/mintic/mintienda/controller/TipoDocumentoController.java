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

import com.mintic.mintienda.model.TipoDocumento;
import com.mintic.mintienda.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tiposdocumento")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	// Crear una tipoDocumento
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TipoDocumento tipoDocumento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoService.save(tipoDocumento));
	}
	
	// Buscar una tipoDocumento por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") String tipoDocumentoId) {
		Optional<TipoDocumento> oTipoDocumento = tipoDocumentoService.findById(tipoDocumentoId); 
		
		if (!oTipoDocumento.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oTipoDocumento);
	}
	
	// Actualizar informacion de la tipoDocumento
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody TipoDocumento tipoDocumento, @PathVariable(value = "id") String tipoDocumentoId) {

		Optional<TipoDocumento> oTipoDocumento = tipoDocumentoService.findById(tipoDocumentoId); 
		
		if (!oTipoDocumento.isPresent())
			return ResponseEntity.notFound().build();

		oTipoDocumento.get().setDescripcion_tipo(tipoDocumento.getDescripcion_tipo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoService.save(oTipoDocumento.get()));
	}
	
	// Borrar una tipoDocumento
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String tipoDocumentoId) {
		
		if (!tipoDocumentoService.findById(tipoDocumentoId).isPresent())
			return ResponseEntity.notFound().build();
		
		tipoDocumentoService.deleteById(tipoDocumentoId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las tipoDocumentos
	@GetMapping
	public List<TipoDocumento> readAll() {
		List<TipoDocumento> listaTipoDocumentos = StreamSupport.stream(tipoDocumentoService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaTipoDocumentos;
	}

}
