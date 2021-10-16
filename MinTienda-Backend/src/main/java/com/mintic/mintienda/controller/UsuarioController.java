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

import com.mintic.mintienda.model.Usuario;
import com.mintic.mintienda.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	// Crear una usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	// Buscar una usuario por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") String usuarioId) {
		Optional<Usuario> oUsuario = usuarioService.findById(usuarioId); 
		
		if (!oUsuario.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oUsuario);
	}
	
	// Actualizar informacion de la usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable(value = "id") String usuarioId) {

		Optional<Usuario> oUsuario = usuarioService.findById(usuarioId); 
		
		if (!oUsuario.isPresent())
			return ResponseEntity.notFound().build();

		oUsuario.get().setTipo_doc_usuario(usuario.getTipo_doc_usuario());
		oUsuario.get().setDocumento_usuario(usuario.getDocumento_usuario());
		oUsuario.get().setNombre_usuario(usuario.getNombre_usuario());
		oUsuario.get().setCorreo_usuario(usuario.getCorreo_usuario());
		oUsuario.get().setContrasena_usuario(usuario.getContrasena_usuario());
		oUsuario.get().setEstado_usuario(usuario.getEstado_usuario());
		oUsuario.get().setTipo_usuario(usuario.getTipo_usuario());

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(oUsuario.get()));
	}
	
	// Borrar una usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String usuarioId) {
		
		if (!usuarioService.findById(usuarioId).isPresent())
			return ResponseEntity.notFound().build();
		
		usuarioService.deleteById(usuarioId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las usuarios
	@GetMapping
	public List<Usuario> readAll() {
		List<Usuario> listaUsuarios = StreamSupport.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaUsuarios;
	}
	
	// Validar Login
	@PostMapping("api/login")
	public Boolean login(@RequestBody Usuario usuario) {
	
		if (usuarioService.login(usuario) == -1) {
			// Mostrar un mensaje con el Error de usuario
			return false;
		}
		
		return true;
	}

}
