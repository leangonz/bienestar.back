package ungs.bienestar.back.dto;

public class CompraItemDto {

	private Long insumo;
	
	private String descripcion;
	
	private Double cantidad;
	
	private Double precioUnitario;
	
	private Double precioTotal;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
