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

import com.mintic.mintienda.model.Categoria;
import com.mintic.mintienda.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	// Crear una categoria
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
	}
	
	// Buscar una categoria por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer categoriaId) {
		Optional<Categoria> oCategoria = categoriaService.findById(categoriaId); 
		
		if (!oCategoria.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oCategoria);
	}
	
	// Actualizar informacion de la categoria
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable(value = "id") Integer categoriaId) {

		Optional<Categoria> oCategoria = categoriaService.findById(categoriaId); 
		
		if (!oCategoria.isPresent())
			return ResponseEntity.notFound().build();

		oCategoria.get().setDescripcion_categoria(categoria.getDescripcion_categoria());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(oCategoria.get()));
	}
	
	// Borrar una categoria
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer categoriaId) {
		
		if (!categoriaService.findById(categoriaId).isPresent())
			return ResponseEntity.notFound().build();
		
		categoriaService.delete(categoriaId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las categorias
	@GetMapping
	public List<Categoria> readAll() {
		List<Categoria> listaCategorias = StreamSupport.stream(categoriaService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaCategorias;
	}
}
