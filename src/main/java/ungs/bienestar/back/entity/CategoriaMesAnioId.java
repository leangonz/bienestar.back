package ungs.bienestar.back.entity;

import java.io.Serializable;

public class CategoriaMesAnioId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String categoria;
	
	private Integer anio;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
}
