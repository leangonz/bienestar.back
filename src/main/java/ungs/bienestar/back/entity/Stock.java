package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsumos;
	
	@NotNull
	private Double cantidad;
	
	@NotNull
	private Integer cantidadMinima;

	public Long getIdInsumos() {
		return idInsumos;
	}

	public void setIdInsumos(Long idInsumos) {
		this.idInsumos = idInsumos;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

}
