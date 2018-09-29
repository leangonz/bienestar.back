package ungs.bienestar.back.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "consumo")
public class Consumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsumo;

	@NotNull
	private LocalDate fecha;

	@NotNull
	private Integer cantidadLactario = 0;

	@NotNull
	private Integer cantidadUnAnio = 0;

	@NotNull
	private Integer cantidadDosAnios = 0;

	@NotNull
	private Integer cantidadTresAnios = 0;

	@NotNull
	private Integer cantidadCuatroCincoAnios = 0;

	@NotNull
	private Integer cantidadAdultos = 0;

	@OneToMany(mappedBy = "consumo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ConsumoDetalle> consumosDetalle;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(Long idConsumo) {
		this.idConsumo = idConsumo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadLactario() {
		return cantidadLactario;
	}

	public void setCantidadLactario(Integer cantidadLactario) {
		this.cantidadLactario = cantidadLactario;
	}

	public Integer getCantidadUnAnio() {
		return cantidadUnAnio;
	}

	public void setCantidadUnAnio(Integer cantidadUnAnio) {
		this.cantidadUnAnio = cantidadUnAnio;
	}

	public Integer getCantidadDosAnios() {
		return cantidadDosAnios;
	}

	public void setCantidadDosAnios(Integer cantidadDosAnios) {
		this.cantidadDosAnios = cantidadDosAnios;
	}

	public Integer getCantidadTresAnios() {
		return cantidadTresAnios;
	}

	public void setCantidadTresAnios(Integer cantidadTresAnios) {
		this.cantidadTresAnios = cantidadTresAnios;
	}

	public Integer getCantidadCuatroCincoAnios() {
		return cantidadCuatroCincoAnios;
	}

	public void setCantidadCuatroCincoAnios(Integer cantidadCuatroCincoAnios) {
		this.cantidadCuatroCincoAnios = cantidadCuatroCincoAnios;
	}

	public Integer getCantidadAdultos() {
		return cantidadAdultos;
	}

	public void setCantidadAdultos(Integer cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}

	public List<ConsumoDetalle> getConsumosDetalle() {
		return consumosDetalle;
	}

	public void setConsumosDetalle(List<ConsumoDetalle> consumosDetalle) {
		this.consumosDetalle = consumosDetalle;
	}

	public void addConsumoDetalle(ConsumoDetalle consumoDetalle) {
		this.consumosDetalle.add(consumoDetalle);
		consumoDetalle.setConsumo(this);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
