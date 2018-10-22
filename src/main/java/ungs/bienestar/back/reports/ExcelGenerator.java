package ungs.bienestar.back.reports;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelGenerator {

	public Workbook generateExcel(List<String> header, List<Fila> rows) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		// Generate fonts
		Font headerFont = createFont(workbook, HSSFColor.WHITE.index, (short) 12, Font.BOLDWEIGHT_BOLD);
		Font contentFont = createFont(workbook, HSSFColor.BLACK.index, (short) 10, Font.BOLDWEIGHT_NORMAL);

		// Generate styles
		CellStyle headerStyle = createStyle(workbook, headerFont, XSSFCellStyle.ALIGN_CENTER, HSSFColor.LIGHT_BLUE.index, true,
				HSSFColor.WHITE.index);
		CellStyle oddRowStyle = createStyle(workbook, contentFont, XSSFCellStyle.ALIGN_LEFT, HSSFColor.AQUA.index,
				true, HSSFColor.GREY_80_PERCENT.index);
		CellStyle evenRowStyle = createStyle(workbook, contentFont, XSSFCellStyle.ALIGN_LEFT, HSSFColor.LIGHT_CORNFLOWER_BLUE.index,
				true, HSSFColor.GREY_80_PERCENT.index);

		Row headerRow = sheet.createRow(0);
		this.populateRow(headerRow, header, headerStyle);
		IntStream.range(0, 14).forEach(x -> sheet.autoSizeColumn(x));
		
		Integer rowIndex = 1;
		for (Fila fila : rows) {
			Row row = sheet.createRow(rowIndex);
			this.populateRow(row, fila.getCells(),rowIndex %2 == 0 ? oddRowStyle : evenRowStyle);
			rowIndex++;
		}
		return workbook;
	}

	private void populateRow(Row row, List<String> list, CellStyle style) {
		Integer columnIndex = 0;
		for (String value : list) {
			Cell cell = row.createCell(columnIndex);
			cell.setCellValue(value);
			cell.setCellStyle(style);
			columnIndex++;
		}
	}

	private Font createFont(Workbook workbook, short fontColor, short fontHeight, short fontBold) {
		 
		Font font = workbook.createFont();
		font.setBoldweight(fontBold);
		font.setColor(fontColor);
		font.setFontName("Arial");
		font.setFontHeightInPoints(fontHeight);
 
		return font;
	}
	
	private CellStyle createStyle(Workbook workbook, Font font, short cellAlign, short cellColor, boolean cellBorder,
			short cellBorderColor) {

		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(cellAlign);
		style.setFillForegroundColor(cellColor);
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		if (cellBorder) {
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);

			style.setTopBorderColor(cellBorderColor);
			style.setLeftBorderColor(cellBorderColor);
			style.setRightBorderColor(cellBorderColor);
			style.setBottomBorderColor(cellBorderColor);
		}

		return style;
	}

}
