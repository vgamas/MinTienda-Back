package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LlaveProveedor {
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_tipo")
	private TipoDocumento tipo_doc_proveedor;

	@Column(nullable = false)
	private Long documento_proveedor;

	public TipoDocumento getTipo_doc_proveedor() {
		return tipo_doc_proveedor;
	}

	public void setTipo_doc_proveedor(TipoDocumento tipo_doc_proveedor) {
		this.tipo_doc_proveedor = tipo_doc_proveedor;
	}

	public Long getDocumento_proveedor() {
		return documento_proveedor;
	}

	public void setDocumento_proveedor(Long documento_proveedor) {
		this.documento_proveedor = documento_proveedor;
	}

	
}
