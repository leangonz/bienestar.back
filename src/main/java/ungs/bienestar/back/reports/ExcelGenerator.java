package ungs.bienestar.back.reports;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelGenerator {

	public Workbook generateExcel(List<String> header, List<Fila> rows) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		Row headerRow = sheet.createRow(0);
		this.populateRow(headerRow, header);

		Integer rowIndex = 1;
		for (Fila fila : rows) {
			Row row = sheet.createRow(rowIndex);
			this.populateRow(row, fila.getCells());
			rowIndex++;
		}
		return workbook;
	}
	
	
	private void populateRow(Row row, List<String> list) {
		Integer columnIndex = 0;
		for (String value : list) {
			Cell cell = row.createCell(columnIndex);
			cell.setCellValue(value);
			columnIndex++;
		}
	}
}
