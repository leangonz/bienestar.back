package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CategoriaId id;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria_principal", insertable = false, updatable = false)
	private CategoriaPrincipal categoriaPrincipal;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria_secundaria", insertable = false, updatable = false)
	private CategoriaSecundaria categoriaSecundaria;

	public CategoriaId getId() {
		return id;
	}

	public void setId(CategoriaId id) {
		this.id = id;
	}

	public CategoriaPrincipal getCategoriaPrincipal() {
		return categoriaPrincipal;
	}

	public void setCategoriaPrincipal(CategoriaPrincipal categoriaPrincipal) {
		this.categoriaPrincipal = categoriaPrincipal;
	}

	public CategoriaSecundaria getCategoriaSecundaria() {
		return categoriaSecundaria;
	}

	public void setCategoriaSecundaria(CategoriaSecundaria categoriaSecundaria) {
		this.categoriaSecundaria = categoriaSecundaria;
	}
	
}
