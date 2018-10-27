package ungs.bienestar.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.DescarteDto;
import ungs.bienestar.back.service.HistorialDescarteService;

@RestController
public class HistorialDescarteController {

	@Autowired
	private HistorialDescarteService historialDescarteService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/registrarHistorialDescarte")
    public Boolean registrarHistorialDescarte(@RequestBody DescarteDto dto) {
        historialDescarteService.registrarHistorial(dto);
		return true;
    }
}
