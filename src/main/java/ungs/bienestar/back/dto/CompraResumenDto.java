package ungs.bienestar.back.dto;

import java.util.Date;

public class CompraResumenDto {

	private Long idOC;
	
	private String factura;
	
	private Date fecha;
	
	private String proveedor;
	
	private String precioTotal;

	public Long getIdOC() {
		return idOC;
	}

	public void setIdOC(Long idOC) {
		this.idOC = idOC;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
