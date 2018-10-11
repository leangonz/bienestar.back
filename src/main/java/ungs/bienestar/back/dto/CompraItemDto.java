package ungs.bienestar.back.dto;

public class CompraItemDto {

	private Long insumo;
	
	private Double cantidad;
	
	private Double precioUnitario;

	public Long getInsumo() {
		return insumo;
	}

	public void setInsumo(Long insumo) {
		this.insumo = insumo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
