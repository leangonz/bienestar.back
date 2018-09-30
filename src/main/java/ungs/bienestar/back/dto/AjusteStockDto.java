package ungs.bienestar.back.dto;

import java.util.Date;
import java.util.List;

public class AjusteStockDto {

	private Date fecha;
	
	private Long motivo;
	
	private List<InsumoDto> insumos;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getMotivo() {
		return motivo;
	}

	public void setMotivo(Long motivo) {
		this.motivo = motivo;
	}

	public List<InsumoDto> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoDto> insumos) {
		this.insumos = insumos;
	}
	
}
