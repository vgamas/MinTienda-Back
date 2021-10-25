package com.mintic.mintienda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LlaveCliente implements Serializable {
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

	@Override
	public int hashCode() {
		return Objects.hash(documento_cliente, tipo_doc_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LlaveCliente other = (LlaveCliente) obj;
		return Objects.equals(documento_cliente, other.documento_cliente)
				&& Objects.equals(tipo_doc_cliente, other.tipo_doc_cliente);
	}	
}
