package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categorias_principales")
public class CategoriaPrincipal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaPrincipal;
	
	@NotBlank
	private String descripcion;

	public Long getIdCategoriaPrincipal() {
		return idCategoriaPrincipal;
	}

	public void setIdCategoriaPrincipal(Long idCategoriaPrincipal) {
		this.idCategoriaPrincipal = idCategoriaPrincipal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
