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

}
