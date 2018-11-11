package ungs.bienestar.back.factory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.entity.Menue;
import ungs.bienestar.back.exception.ConsumerWithException;
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
			return menu;
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}
