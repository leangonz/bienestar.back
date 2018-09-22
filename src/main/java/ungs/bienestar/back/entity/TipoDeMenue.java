package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tipos_de_menues")
public class TipoDeMenue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTiposMenues;
	
	@NotBlank
	private String descripcion;

	public Long getIdTiposMenues() {
		return idTiposMenues;
	}

	public void setIdTiposMenues(Long idTiposMenues) {
		this.idTiposMenues = idTiposMenues;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
