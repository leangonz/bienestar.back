package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consumo_detalle")
public class ConsumoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsumoDetalle;

	@ManyToOne
    @JoinColumn(name="id_consumo")
	private Consumo consumo;
	
	@ManyToOne
    @JoinColumn(name="id_insumos")
	private Insumo insumo;
	
	@ManyToOne
    @JoinColumn(name="id_menues")
	private Menue menue;

	private Double cantidad;
	
	public Long getIdConsumoDetalle() {
		return idConsumoDetalle;
	}

	public void setIdConsumoDetalle(Long idConsumoDetalle) {
		this.idConsumoDetalle = idConsumoDetalle;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
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
