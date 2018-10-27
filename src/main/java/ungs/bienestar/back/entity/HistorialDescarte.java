package ungs.bienestar.back.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historial_descarte")
public class HistorialDescarte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
	
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name="id_menu")
	private Menue menue;
	
	private Double cantidad;

	public Long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Menue getMenue() {
		return menue;
	}

	public void setMenue(Menue menue) {
		this.menue = menue;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
}
