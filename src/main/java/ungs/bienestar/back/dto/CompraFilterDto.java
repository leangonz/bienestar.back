package ungs.bienestar.back.dto;

public class CompraFilterDto {

	private Long idProveedor;
	
	private String factura;

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}
	
}
