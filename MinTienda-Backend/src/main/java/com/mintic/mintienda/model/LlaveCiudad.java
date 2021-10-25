package com.mintic.mintienda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LlaveCiudad implements Serializable {

	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "codigo_departamento")
	private Departamento codigo_dpto_ciudad;

	@Column(nullable = false, length=3)
	private String codigo_ciudad;

	public String getCodigo_ciudad() {
		return codigo_ciudad;
	}

	public void setCodigo_ciudad(String codigo_ciudad) {
		this.codigo_ciudad = codigo_ciudad;
	}

	public Departamento getCodigo_dpto_ciudad() {
		return codigo_dpto_ciudad;
	}

	public void setCodigo_dpto_ciudad(Departamento codigo_dpto_ciudad) {
		this.codigo_dpto_ciudad = codigo_dpto_ciudad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_ciudad, codigo_dpto_ciudad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LlaveCiudad other = (LlaveCiudad) obj;
		return Objects.equals(codigo_ciudad, other.codigo_ciudad)
				&& Objects.equals(codigo_dpto_ciudad, other.codigo_dpto_ciudad);
	}
}
