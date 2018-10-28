package ungs.bienestar.back.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ComboDto;
import ungs.bienestar.back.dto.DescarteDto;
import ungs.bienestar.back.dto.MenuCantidadDto;
import ungs.bienestar.back.service.ComboService;
import ungs.bienestar.back.service.HistorialDescarteService;

@RestController
public class HistorialDescarteController {

	@Autowired
	private HistorialDescarteService historialDescarteService;
	
	@Autowired
	private ComboService comboService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtenerMenues")
    public List<MenuCantidadDto> obtenerMenues() {
		return comboService.menuesItems().stream().map( x -> this.comboToDescarteDTO(x)).collect(Collectors.toList());
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/registrarHistorialDescarte")
    public Boolean registrarHistorialDescarte(@RequestBody DescarteDto dto) {
        historialDescarteService.registrarHistorial(dto);
		return true;
    }
	
	private MenuCantidadDto comboToDescarteDTO (ComboDto combo) {
		MenuCantidadDto menu = new MenuCantidadDto();
		menu.setIdMenu(combo.getId());
		menu.setDescripcion(combo.getDescripcion());
		return menu;
	}
}
