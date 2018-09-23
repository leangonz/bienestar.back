package ungs.bienestar.back.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "menues")
public class Menue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMenues;

	@NotBlank
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_tipos_menues")
	private TipoDeMenue tipoDeMenue;

	@ManyToMany
	@JoinTable(name = "insumos_por_menues", joinColumns = @JoinColumn(name = "id_menues"), inverseJoinColumns = @JoinColumn(name = "id_insumos"))
	private List<Insumo> insumos;

	public Long getIdMenues() {
		return idMenues;
	}

	public void setIdMenues(Long idMenues) {
		this.idMenues = idMenues;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoDeMenue getTipoDeMenue() {
		return tipoDeMenue;
	}

	public void setTipoDeMenue(TipoDeMenue tipoDeMenue) {
		this.tipoDeMenue = tipoDeMenue;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

}
