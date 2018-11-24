package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.InsumoFilterDto;
import ungs.bienestar.back.dto.MovimientoDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.MovimientoService;

@RestController
public class MovimientosController {

	@Autowired
	private MovimientoService movimientoService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/filtrarMovimientos")
	//@PreAuthorize("hasAuthority('abmInsumo')")
    public List<MovimientoDto> filtrarCompra(@RequestBody InsumoFilterDto filter) throws NotFoundException {
		return movimientoService.filtrarMovimientos(filter.getIdInsumo());
    }
}
