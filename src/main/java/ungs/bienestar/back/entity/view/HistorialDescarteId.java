package ungs.bienestar.back.entity.view;

import java.io.Serializable;

public class HistorialDescarteId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String menu;
	
	private Integer anio;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
}
