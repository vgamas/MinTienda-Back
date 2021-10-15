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

import com.mintic.mintienda.model.Cliente;
import com.mintic.mintienda.model.LlaveCliente;
import com.mintic.mintienda.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	// Crear una cliente
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
	
	// Buscar una cliente por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") LlaveCliente clienteId) {
		Optional<Cliente> oCliente = clienteService.findById(clienteId); 
		
		if (!oCliente.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oCliente);
	}
	
	// Actualizar informacion de la cliente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable(value = "id") LlaveCliente clienteId) {

		Optional<Cliente> oCliente = clienteService.findById(clienteId); 
		
		if (!oCliente.isPresent())
			return ResponseEntity.notFound().build();

		oCliente.get().setNombre_cliente(cliente.getNombre_cliente());
		oCliente.get().setDireccion_cliente(cliente.getDireccion_cliente());
		oCliente.get().setCiudad_cliente(cliente.getCiudad_cliente());
		oCliente.get().setTelefono_cliente(cliente.getTelefono_cliente());
		oCliente.get().setCorreo_cliente(cliente.getCorreo_cliente());

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(oCliente.get()));
	}
	
	// Borrar una cliente
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") LlaveCliente clienteId) {
		
		if (!clienteService.findById(clienteId).isPresent())
			return ResponseEntity.notFound().build();
		
		clienteService.deleteById(clienteId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las clientes
	@GetMapping
	public List<Cliente> readAll() {
		List<Cliente> listaClientes = StreamSupport.stream(clienteService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaClientes;
	}
}
