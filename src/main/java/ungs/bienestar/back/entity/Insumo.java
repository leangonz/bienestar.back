package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "insumos")
public class Insumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInsumos;

	@NotBlank
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idUnidadMedida")
	private UnidadDeMedida unidadDeMedida;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "id_categoria_principal", referencedColumnName = "id_categoria_principal"),
			@JoinColumn(name = "id_categoria_secundaria", referencedColumnName = "id_categoria_secundaria") })
	private Categoria categoria;

	private Boolean activo;
	
	public Insumo() {
	}

	public Insumo(Long idInsumos) {
		super();
		this.idInsumos = idInsumos;
	}

	public Long getIdInsumos() {
		return idInsumos;
	}

	public void setIdInsumos(Long idInsumo) {
		this.idInsumos = idInsumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadDeMedida getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
