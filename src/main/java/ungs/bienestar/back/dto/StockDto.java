package ungs.bienestar.back.dto;

public class StockDto {

	private String insumo;
	
	private Double actual;
	
	private String cantidadMinima;
	
	private String unidadMedida;

	public String getInsumo() {
		return insumo;
	}

	public void setInsumo(String insumo) {
		this.insumo = insumo;
	}

	public Double getActual() {
		return actual;
	}

	public void setActual(Double actual) {
		this.actual = actual;
	}

	public String getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(String cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
}
