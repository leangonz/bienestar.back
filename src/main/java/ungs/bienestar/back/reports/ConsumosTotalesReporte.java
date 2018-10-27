package ungs.bienestar.back.reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.entity.Consumo;
import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.repository.ConsumoRepository;

@Component
public class ConsumosTotalesReporte extends Report {

	//TODO cambiar a service
	@Autowired
	private ConsumoRepository repository;
	
	public ConsumosTotalesReporte() {
		super(Arrays.asList("fecha", "comensales", "tipo menu", "menu", "insumo", "cantidad"),
				Arrays.asList("desde", "hasta"), CONSUMOS_TOTALES);
	}

	@Override
	public List<Fila> body(Map<String, String> filters) {
		List<Consumo> rows = repository.findAll();
		List<Fila> filas = new ArrayList<>();
		rows.stream().forEach(x-> filas.addAll(mapper(x)));
		return filas;
	}

	private List<Fila> mapper(Consumo item) {
		List<Fila> filas = new ArrayList<>();
		Fila row = new Fila(0);
		row.addCell(item.getFecha().format(new DateTimeFormatterFactory("dd/MM/yyyy").createDateTimeFormatter()));
		row.addCell(this.totalizarComensales(item).toString());
		filas.add(row);
		row.addCell(""); //TODO no tenemos el tipo de menu
		row.addCell(""); //TODO no tenemos menu
		filas.addAll(item.getConsumosDetalle().stream().map(x -> createRowInsumos(x, row.getCells().size())).collect(Collectors.toList()));
		return filas;
	}
	
	private Fila createRowInsumos(ConsumoDetalle item, Integer inicio) {
		Fila row = new Fila(inicio);
		row.addCell(item.getInsumo().getDescripcion());
		row.addCell(item.getCantidad().toString());
		return row;
	}
	
	//FIXME pasar la logica al CONSUMO
	private Integer totalizarComensales(Consumo consumo) {
		return consumo.getCantidadAdultos() + consumo.getCantidadCuatroCincoAnios() + 
				consumo.getCantidadDosAnios() + consumo.getCantidadLactario() +
				consumo.getCantidadTresAnios() + consumo.getCantidadUnAnio();
	}
}
