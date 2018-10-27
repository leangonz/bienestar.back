package ungs.bienestar.back.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.factory.ReportesFactory;
import ungs.bienestar.back.reports.ExcelGenerator;
import ungs.bienestar.back.reports.Report;
import ungs.bienestar.back.reports.ResourceWriter;
import ungs.bienestar.back.reports.Fila;

@Service
public class ReporteService {

	@Autowired
	private ReportesFactory reportesFactory;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private ResourceWriter writer;
	
	public Resource exportReporte(Map<String, String> params) throws IOException {
		Report template = reportesFactory.obtenerReporteTemplate(Integer.valueOf(params.get("type")));
		Fila header = template.header();
		List<Fila> rows = template.body(params);
		Workbook workbook = excelGenerator.generateExcel(header, rows);
		return writer.export(workbook);
	}
	
}
