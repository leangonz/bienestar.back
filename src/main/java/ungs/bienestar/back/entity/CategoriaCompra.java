package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria_compra")
public class CategoriaCompra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaCompra;
	
	@NotBlank
	private String categoria;

	public Long getIdCategoriaCompra() {
		return idCategoriaCompra;
	}

	public void setIdCategoriaCompra(Long idCategoriaCompra) {
		this.idCategoriaCompra = idCategoriaCompra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
