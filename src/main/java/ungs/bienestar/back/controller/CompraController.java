package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraFilterDto;
import ungs.bienestar.back.dto.CompraResumenDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.CompraService;

@RestController
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/cargarCompra")
	@PreAuthorize("hasAuthority('cargarCompra')")
    public Boolean cargarCompra(@RequestBody CompraDto dto) {
        try {
			compraService.guardarCompra(dto);
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
		return true;
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/filtrarCompra")
	@PreAuthorize("hasAuthority('cargarCompra')")
    public List<CompraResumenDto> filtrarCompra(@RequestBody CompraFilterDto filter) {
		return compraService.filtrarCompra(filter);
    }
}
