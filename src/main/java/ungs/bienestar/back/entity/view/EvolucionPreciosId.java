package ungs.bienestar.back.entity.view;

import java.io.Serializable;
import java.util.Date;

public class EvolucionPreciosId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idInsumo;
	
	private Double precio;
	
	private Date fecha;

	public Long getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
