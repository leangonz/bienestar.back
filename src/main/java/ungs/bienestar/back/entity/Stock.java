package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stock")
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    private Long idInsumos;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_insumos")
	private Insumo insumo;
	
	@NotNull
	private Double cantidad;
	
	@NotNull
	private Double cantidadMinima;

	public Long getIdInsumos() {
		return idInsumos;
	}

	public void setIdInsumos(Long idInsumos) {
		this.idInsumos = idInsumos;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

}
