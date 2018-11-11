package ungs.bienestar.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.InsumoDto;
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
}
