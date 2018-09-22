package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "unidades_de_medida")
public class UnidadDeMedida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidadMedida;
	
	@NotBlank
	private String descripcion;

	public UnidadDeMedida() {
	}

	public UnidadDeMedida(Long idUnidadMedida, @NotBlank String descripcion) {
		super();
		this.idUnidadMedida = idUnidadMedida;
		this.descripcion = descripcion;
	}

	public Long getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
