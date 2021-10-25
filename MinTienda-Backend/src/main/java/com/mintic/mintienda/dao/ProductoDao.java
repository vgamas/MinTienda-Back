package com.mintic.mintienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.mintienda.model.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {
	
	@Query(value="SELECT * FROM PRODUCTO WHERE categoria_producto_codigo_categoria = :categoria", nativeQuery = true)
	public List<Producto>listarPorCategoria(Integer categoria);

}
