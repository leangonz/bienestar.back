package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.dto.InsumoFilterDto;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.InsumosService;

@RestController
public class InsumosController {

	@Autowired
	private InsumosService insumoService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/crearInsumo")
	@PreAuthorize("hasAuthority('abmInsumo')")
    public Boolean crearInsumo(@RequestBody InsumoDto dto) {
		insumoService.crearInsumo(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/modificarInsumo")
	@PreAuthorize("hasAuthority('abmInsumo')")
    public Boolean modificarInsumo(@RequestBody InsumoDto dto) throws NotFoundException {
		insumoService.modificarInsumo(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/filtrarInsumo")
	@PreAuthorize("hasAuthority('abmInsumo')")
    public List<InsumoDto> filtrarCompra(@RequestBody InsumoFilterDto filter) throws NotFoundException {
		return insumoService.filtrarInsumos(filter.getIdInsumo());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/borrarInsumo")
	@PreAuthorize("hasAuthority('abmInsumo')")
    public Boolean borrarInsumo(@RequestBody InsumoFilterDto id) throws NotFoundException {
		return insumoService.borrarProveedor(id.getIdInsumo());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/buscarInsumo")
	@PreAuthorize("hasAuthority('abmInsumo')")
    public InsumoDto buscarInsumo(@RequestBody InsumoFilterDto id) throws NotFoundException {
		return insumoService.obtenerInsumoDtoBy(id.getIdInsumo());
    }
}
