package ungs.bienestar.back.factory;

import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.entity.Menue;

@Component
public class MenuFactory {

	public Menue crearMenu(PreparacionDto dto) {
		Menue menu = new Menue();
		return menu;
	}
}
