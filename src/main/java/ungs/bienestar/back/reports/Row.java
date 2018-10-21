package ungs.bienestar.back.reports;

import java.util.ArrayList;
import java.util.List;

public class Row {

	private List<String> cells = new ArrayList<>();
	
	public void addCell(String value) {
		cells.add(value);
	}
}
