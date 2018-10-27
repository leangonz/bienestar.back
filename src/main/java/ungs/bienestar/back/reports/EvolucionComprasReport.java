package ungs.bienestar.back.reports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.entity.view.EvolucionPreciosView;
import ungs.bienestar.back.repository.EvolucionPreciosViewRepository;

@Component
public class EvolucionComprasReport extends Report{

	@Autowired
	private EvolucionPreciosViewRepository repository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public EvolucionComprasReport() {
		super(Arrays.asList("insumo","precio","fecha"), Arrays.asList("idInsumo", "desde", "hasta"), EVOLUCION_PRECIOS);
	}

	@Override
	public List<Fila> body(Map<String, String> filters) {
		//FIXME cambiar esta asquerosidad
		Long idInsumo = null;
		try {
			idInsumo = Long.valueOf(filters.get("idInsumo"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Date desde = null;
		try {
			desde = sdf.parse(filters.get("desde"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date hasta = null;
		try {
			hasta = sdf.parse(filters.get("hasta"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<EvolucionPreciosView> rows = repository.findBy(idInsumo, desde, hasta);
		return rows.stream().map(x -> this.mapper(x)).collect(Collectors.toList());
	}

	private Fila mapper(EvolucionPreciosView item) {
		Fila row = new Fila(0);
		row.addCell(item.getInsumo());
		row.addCell(item.getPrecio().toString());
		row.addCell(sdf.format(item.getFecha()));
		return row;
	}
}
