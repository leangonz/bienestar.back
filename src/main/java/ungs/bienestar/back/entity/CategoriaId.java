package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_categoria_principal")
	private Long idCategoriaPrincipal;
	
	@Column(name = "id_categoria_secundaria")
	private Long idCategoriaSecundaria;

	public Long getIdCategoriaPrincipal() {
		return idCategoriaPrincipal;
	}

	public void setIdCategoriaPrincipal(Long idCategoriaPrincipal) {
		this.idCategoriaPrincipal = idCategoriaPrincipal;
	}

	public Long getIdCategoriaSecundaria() {
		return idCategoriaSecundaria;
	}

	public void setIdCategoriaSecundaria(Long idCategoriaSecundaria) {
		this.idCategoriaSecundaria = idCategoriaSecundaria;
	}
	
}
