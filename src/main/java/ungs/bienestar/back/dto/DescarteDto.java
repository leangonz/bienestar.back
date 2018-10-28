package ungs.bienestar.back.dto;

import java.util.Date;
import java.util.List;

public class DescarteDto {

	private Date fecha;
	
	private List<MenuCantidadDto> menues;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<MenuCantidadDto> getMenues() {
		return menues;
	}

	public void setMenues(List<MenuCantidadDto> menuCantidad) {
		this.menues = menuCantidad;
	}
	
}
