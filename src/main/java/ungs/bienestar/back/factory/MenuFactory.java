package ungs.bienestar.back.factory;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.entity.Menue;
import ungs.bienestar.back.exception.ConsumerWithException;
import ungs.bienestar.back.exception.LambdaExceptionWrapper;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.InsumosService;
import ungs.bienestar.back.service.TipoMenuService;

@Component
public class MenuFactory {

	@Autowired
	private TipoMenuService tipoMenuService;
	
	@Autowired
	private InsumosService insumoService;
	
	public Menue crearMenu(PreparacionDto dto) {
	
		try {
			Menue menu = new Menue();
			menu.setDescripcion(dto.getNombreMenu());
			menu.setTipoDeMenue(tipoMenuService.obtenerTipoMenuBy(dto.getTipoMenu()));
			menu.setInsumos(new ArrayList<>());
			dto.getInsumos().forEach(ConsumerWithException.wrapper(i -> menu.getInsumos().add(insumoService.obtenerInsumoBy(i.getId()))));
			menu.setActivo(true);
			return menu;
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Menue actualizarMenu(PreparacionDto origen, Menue destino) throws NotFoundException {
		destino.setTipoDeMenue(tipoMenuService.obtenerTipoMenuBy(origen.getTipoMenu()));
		destino.getInsumos().clear();
		destino.getInsumos().addAll(origen.getInsumos().stream().map(LambdaExceptionWrapper.wrapper(i -> insumoService.obtenerInsumoBy(i.getId()))).collect(Collectors.toList()));
		return destino;
	}
}
