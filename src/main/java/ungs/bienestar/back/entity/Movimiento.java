package ungs.bienestar.back.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimientos;
	
	@ManyToOne
    @JoinColumn(name="id_insumos")
	private Insumo insumo;
	
	private Integer cantidadAjustada;
	
	@ManyToOne
    @JoinColumn(name="motivos_id_motivos")
	private Motivo motivo;
	
	private LocalDate fecha;

	public Long getIdMovimientos() {
		return idMovimientos;
	}

	public void setIdMovimientos(Long idMovimientos) {
		this.idMovimientos = idMovimientos;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Integer getCantidadAjustada() {
		return cantidadAjustada;
	}

	public void setCantidadAjustada(Integer cantidadAjustada) {
		this.cantidadAjustada = cantidadAjustada;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
