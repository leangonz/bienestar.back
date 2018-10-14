package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraResumenDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.CompraService;

@RestController
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/cargarCompra")
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
    public List<CompraResumenDto> filtrarCompra(@RequestBody Long idProveedor) {
		return compraService.filtrarCompra(idProveedor);
    }
}
