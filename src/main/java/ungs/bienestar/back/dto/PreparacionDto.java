package ungs.bienestar.back.dto;

import java.util.List;

public class PreparacionDto {

	private Long idMenu;
	
	private String nombreMenu;
	
	private Long tipoMenu;
	
	private String descTipo;
	
	private List<InsumoDto> insumos;

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Long getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(Long tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public List<InsumoDto> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoDto> insumos) {
		this.insumos = insumos;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}
	
}
