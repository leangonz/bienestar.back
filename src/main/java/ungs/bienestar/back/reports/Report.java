package ungs.bienestar.back.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Report {
	
	public static final Integer COMPRAS_TOTALES = 1;
	public static final Integer EVOLUCION_PRECIOS = 2;
	public static final Integer HISTORIAL_DESCARTE = 3;
	
	public static Map<Integer, Report> instanciasRegistradas = new HashMap<>();
	
	private List<String> header;
	
	private List<String> filters;
	
	public abstract List<Fila> body(Map<String, String> filters);

	public List<String> header(){
		return header;
	}
	
	public List<String> filters(){
		return filters;
	}
	
	protected Report(List<String> header, List<String> filters, Integer idReporte) {
		this.header = header;
		this.filters = filters;
		instanciasRegistradas.put(idReporte, this);
	}
	
}
