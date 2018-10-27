package ungs.bienestar.back.factory;

import org.springframework.stereotype.Component;

import ungs.bienestar.back.reports.Report;

@Component
public class ReportesFactory {

	//FIXME esto no es un factory, transformarlo en un registry
	public Report obtenerReporteTemplate(Integer type) {
		return Report.instanciasRegistradas.get(type);
	}
	
}
