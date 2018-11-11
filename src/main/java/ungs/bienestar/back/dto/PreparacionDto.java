package ungs.bienestar.back.dto;

import java.util.List;

public class PreparacionDto {

	private String nombreMenu;
	
	private Long tipoMenu;
	
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
	
}
