package ungs.bienestar.back.entity.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "evolucion_precios")
@Immutable
@IdClass(value = EvolucionPreciosId.class)
public class EvolucionPreciosView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long idInsumo;
	
	private String insumo;
	
	@Id
	private Double precio;
	
	@Id
	private Date fecha;

	public Long getIdInsumo() {
		return idInsumo;
	}
	
	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
	}
	
	public String getInsumo() {
		return insumo;
	}

	public void setInsumo(String insumo) {
		this.insumo = insumo;
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
