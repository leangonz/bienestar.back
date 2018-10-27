package ungs.bienestar.back.dto;

import java.util.Date;
import java.util.List;

public class DescarteDto {

	private Date fecha;
	
	private List<MenuCantidadDto> menuCantidad;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<MenuCantidadDto> getMenuCantidad() {
		return menuCantidad;
	}

	public void setMenuCantidad(List<MenuCantidadDto> menuCantidad) {
		this.menuCantidad = menuCantidad;
	}
	
}
