package ungs.bienestar.back.reports;

import java.util.ArrayList;
import java.util.List;

public class Fila {

	private List<String> cells = new ArrayList<>();
	
	private Integer initialColumnNumber;

	public Fila(Integer initialColumnNumber) {
		this.initialColumnNumber = initialColumnNumber;
	}
	
	public void addCell(String value) {
		cells.add(value);
	}

	public List<String> getCells() {
		return cells;
	}
	
	public Integer getInitialColumnNumber() {
		return this.initialColumnNumber;
	}
}
