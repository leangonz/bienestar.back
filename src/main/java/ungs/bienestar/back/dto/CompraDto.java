package ungs.bienestar.back.dto;

import java.util.Date;
import java.util.List;

public class CompraDto {

	private Date fecha;
	
	private Long proveedor;
	
	private Long area;
	
	private Long categoria;
	
	private List<CompraItemDto> items;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getProveedor() {
		return proveedor;
	}

	public void setProveedor(Long proveedor) {
		this.proveedor = proveedor;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public List<CompraItemDto> getItems() {
		return items;
	}

	public void setItems(List<CompraItemDto> items) {
		this.items = items;
	}
	
}
