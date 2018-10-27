package ungs.bienestar.back.factory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.DescarteDto;
import ungs.bienestar.back.dto.MenuCantidadDto;
import ungs.bienestar.back.entity.HistorialDescarte;
import ungs.bienestar.back.exception.LambdaExceptionWrapper;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.MenuService;

@Component
public class HistorialDescarteFactory {

	@Autowired
	private MenuService menuService;

	public List<HistorialDescarte> crearHistorialDescarte(DescarteDto descarte) {
		List<HistorialDescarte> historiales = descarte.getMenuCantidad().stream()
				.map(LambdaExceptionWrapper.wrapper(x -> mapper(x, descarte.getFecha()))).collect(Collectors.toList());
		return historiales;
	}

	private HistorialDescarte mapper(MenuCantidadDto dto, Date fecha) throws NotFoundException {
		HistorialDescarte historial = new HistorialDescarte();
		historial.setCantidad(dto.getCantidad());
		historial.setFecha(fecha);
		historial.setMenue(menuService.obtenerMenue(dto.getIdMenu()));
		return historial;
	}
}
