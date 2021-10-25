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

import com.mintic.mintienda.model.Producto;
import com.mintic.mintienda.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	// Crear una producto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}
	
	// Buscar una producto por su codigo
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long productoId) {
		Optional<Producto> oProducto = productoService.findById(productoId); 
		
		if (!oProducto.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oProducto);
	}
	
	// Actualizar informacion de la producto
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable(value = "id") Long productoId) {

		Optional<Producto> oProducto = productoService.findById(productoId); 
		
		if (!oProducto.isPresent())
			return ResponseEntity.notFound().build();

		oProducto.get().setCodigo_producto(producto.getCodigo_producto());
		oProducto.get().setCategoria_producto(producto.getCategoria_producto());
		oProducto.get().setNombre_producto(producto.getNombre_producto());
		oProducto.get().setProveedor_producto(producto.getProveedor_producto());
		oProducto.get().setPrecio_compra(producto.getPrecio_compra());
		oProducto.get().setIva_compra(producto.getIva_compra());
		oProducto.get().setPrecio_venta(producto.getPrecio_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(oProducto.get()));
	}
	
	// Borrar una producto
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long productoId) {
		
		if (!productoService.findById(productoId).isPresent())
			return ResponseEntity.notFound().build();
		
		productoService.deleteById(productoId);
		
		return ResponseEntity.ok().build();
	}
	
	// Listar todas las productos de una categoria
	@GetMapping("/categoria/{id}")
	public List<Producto> readAll(@PathVariable(value = "id") Integer categoria) {

		List<Producto> listaProductos = StreamSupport.stream(productoService.findAllByCategoria(categoria).spliterator(), false).collect(Collectors.toList());
		
		return listaProductos;
	}

}
