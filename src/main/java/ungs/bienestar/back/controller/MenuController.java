package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.MenuFilterDto;
import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/crearMenu")
	@PreAuthorize("hasAuthority('abmMenu')")
    public Boolean crearMenu(@RequestBody PreparacionDto dto) {
		menuService.crearMenu(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/modificarMenu")
	@PreAuthorize("hasAuthority('abmMenu')")
    public Boolean modificarMenu(@RequestBody PreparacionDto dto) throws NotFoundException {
		menuService.modificarMenu(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/filtrarMenu")
	@PreAuthorize("hasAuthority('abmMenu')")
    public List<PreparacionDto> filtrarCompra(@RequestBody MenuFilterDto filter) throws NotFoundException {
		return menuService.filtrarMenu(filter.getIdMenu());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/borrarMenu")
	@PreAuthorize("hasAuthority('abmMenu')")
    public Boolean borrarMenu(@RequestBody MenuFilterDto id) throws NotFoundException {
		return menuService.borrarMenu(id.getIdMenu());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/buscarMenu")
	@PreAuthorize("hasAuthority('abmMenu')")
    public PreparacionDto buscarInsumo(@RequestBody MenuFilterDto id) throws NotFoundException {
		return menuService.obtenerMenueDto(id.getIdMenu());
    }
}
