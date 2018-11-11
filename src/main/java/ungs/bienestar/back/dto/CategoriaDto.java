package ungs.bienestar.back.dto;

public class CategoriaDto {

	private Long idCategoriaPrincipal;
	
	private Long idCategoriaSecundaria;
	
	private String descripcion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
