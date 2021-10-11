package com.mintic.mintienda.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LlaveCliente {
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_tipo")
	private TipoDocumento tipo_doc_cliente;

	@Column(nullable = false)
	private Long documento_cliente;

	public TipoDocumento getTipo_doc_cliente() {
		return tipo_doc_cliente;
	}

	public void setTipo_doc_cliente(TipoDocumento tipo_doc_cliente) {
		this.tipo_doc_cliente = tipo_doc_cliente;
	}

	public Long getDocumento_cliente() {
		return documento_cliente;
	}

	public void setDocumento_cliente(Long documento_cliente) {
		this.documento_cliente = documento_cliente;
	}
	
}
