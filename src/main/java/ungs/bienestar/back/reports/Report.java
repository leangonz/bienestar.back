package ungs.bienestar.back.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Report {
	
	public static Map<Long, Report> instanciasRegistradas = new HashMap<>();
	
	private List<String> header;
	
	private List<String> filters;
	
	public abstract List<Fila> body(Map<String, String> filters);

	public List<String> header(){
		return header;
	}
	
	public List<String> filters(){
		return filters;
	}
	
	protected Report(List<String> header, List<String> filters) {
		this.header = header;
		this.filters = filters;
		instanciasRegistradas.put(1l, this);
	}
	
}
