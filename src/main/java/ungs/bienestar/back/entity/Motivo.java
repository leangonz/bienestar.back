package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "motivos")
public class Motivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotivos;
	
	@NotBlank
	private String descripcion;

	public Motivo(Long idMotivos) {
		super();
		this.idMotivos = idMotivos;
	}

	public Long getIdMotivos() {
		return idMotivos;
	}

	public void setIdMotivos(Long idMotivos) {
		this.idMotivos = idMotivos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
