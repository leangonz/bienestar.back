package ungs.bienestar.back.reports;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.entity.view.GrupoEtarioView;
import ungs.bienestar.back.repository.GrupoEtarioViewRepository;

@Component
public class GrupoEtarioReport extends Report{

	@Autowired
	private GrupoEtarioViewRepository repository;

	public GrupoEtarioReport() {
		super(Arrays.asList("Momento/Categoria", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre"), Arrays.asList("anio"), GRUPO_ETARIO);
	}

	@Override
	public List<Fila> body(Map<String, String> filters) {
		List<GrupoEtarioView> rows = repository.findByAnio(Integer.valueOf(filters.get("anio")));
		return rows.stream().map(x -> this.mapper(x)).collect(Collectors.toList());
	}

	private Fila mapper(GrupoEtarioView item) {
		Fila row = new Fila(0);
		row.addCell(item.getGrupo());
		row.addCell(item.getEnero().toString());
		row.addCell(item.getFebrero().toString());
		row.addCell(item.getMarzo().toString());
		row.addCell(item.getAbril().toString());
		row.addCell(item.getMayo().toString());
		row.addCell(item.getJunio().toString());
		row.addCell(item.getJulio().toString());
		row.addCell(item.getAgosto().toString());
		row.addCell(item.getSeptiembre().toString());
		row.addCell(item.getOctubre().toString());
		row.addCell(item.getNoviembre().toString());
		row.addCell(item.getDiciembre().toString());
		return row;
	}

}
