package com.mintic.mintienda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LlaveProveedor implements Serializable {
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

	@Override
	public int hashCode() {
		return Objects.hash(documento_proveedor, tipo_doc_proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LlaveProveedor other = (LlaveProveedor) obj;
		return Objects.equals(documento_proveedor, other.documento_proveedor)
				&& Objects.equals(tipo_doc_proveedor, other.tipo_doc_proveedor);
	}

	
}
