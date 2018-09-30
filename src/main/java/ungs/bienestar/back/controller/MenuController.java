package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/crearMenu")
    public Boolean crearMenu(@RequestBody PreparacionDto dto) {
		menuService.crearMenu(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/actualizarMenu")
    public Boolean actualizarMenu(@RequestBody List<InsumoDto> insumos, Long idMenu) throws NotFoundException {
		menuService.modificarMenu(idMenu, insumos);
        return true;
    }
}
