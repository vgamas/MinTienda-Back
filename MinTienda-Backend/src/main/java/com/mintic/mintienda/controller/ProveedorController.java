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

import com.mintic.mintienda.model.Proveedor;
import com.mintic.mintienda.model.TipoDocumento;
import com.mintic.mintienda.model.LlaveProveedor;
import com.mintic.mintienda.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	// Crear una proveedor
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
	}
	
	// Buscar una proveedor por su codigo
	@GetMapping("/id")
	public ResponseEntity<?> read(String tipo, Long documento) {
		
		TipoDocumento tipoDoc = new TipoDocumento();
		LlaveProveedor proveedorId = new LlaveProveedor();
		
		tipoDoc.setCodigo_tipo(tipo);
		proveedorId.setTipo_doc_proveedor(tipoDoc);
		proveedorId.setDocumento_proveedor(documento);
		
		Optional<Proveedor> oProveedor = proveedorService.findById(proveedorId); 
		
		if (!oProveedor.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oProveedor);
	}
	
	// Actualizar informacion de la proveedor
	@PutMapping("/id")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedor, String tipo, Long documento) {
		
		TipoDocumento tipoDoc = new TipoDocumento();
		LlaveProveedor proveedorId = new LlaveProveedor();
		
		tipoDoc.setCodigo_tipo(tipo);
		proveedorId.setTipo_doc_proveedor(tipoDoc);
		proveedorId.setDocumento_proveedor(documento);

		Optional<Proveedor> oProveedor = proveedorService.findById(proveedorId); 
		
		if (!oProveedor.isPresent())
			return ResponseEntity.notFound().build();

		oProveedor.get().setNombre_proveedor(proveedor.getNombre_proveedor());
		oProveedor.get().setDireccion_proveedor(proveedor.getDireccion_proveedor());
		oProveedor.get().setCiudad_proveedor(proveedor.getCiudad_proveedor());
		oProveedor.get().setTelefono_proveedor(proveedor.getTelefono_proveedor());
		oProveedor.get().setCorreo_proveedor(proveedor.getCorreo_proveedor());
		oProveedor.get().setEstado_proveedor(proveedor.getEstado_proveedor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(oProveedor.get()));
	}
	
	// Borrar una proveedor
	@DeleteMapping("/id")
	public ResponseEntity<?> delete(String tipo, Long documento) {
		
		TipoDocumento tipoDoc = new TipoDocumento();
		LlaveProveedor proveedorId = new LlaveProveedor();
		
		tipoDoc.setCodigo_tipo(tipo);
		proveedorId.setTipo_doc_proveedor(tipoDoc);
		proveedorId.setDocumento_proveedor(documento);
		
		if (!proveedorService.findById(proveedorId).isPresent())
			return ResponseEntity.notFound().build();
		
		proveedorService.deleteById(proveedorId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las proveedors
	@GetMapping
	public List<Proveedor> readAll() {
		List<Proveedor> listaProveedors = StreamSupport.stream(proveedorService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaProveedors;
	}
}
