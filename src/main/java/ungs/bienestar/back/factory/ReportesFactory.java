package ungs.bienestar.back.factory;

import org.springframework.stereotype.Component;

import ungs.bienestar.back.reports.Report;

@Component
public class ReportesFactory {

	public Report obtenerReporteTemplate(Long type) {
		return Report.instanciasRegistradas.get(type);
	}
	
}
