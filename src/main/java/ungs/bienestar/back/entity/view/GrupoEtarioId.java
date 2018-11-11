package ungs.bienestar.back.entity.view;

import java.io.Serializable;

public class GrupoEtarioId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String grupo;
	
	private Integer anio;

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	

}
