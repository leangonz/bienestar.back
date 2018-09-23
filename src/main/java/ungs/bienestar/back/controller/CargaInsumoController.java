package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.service.InsumosService;

@RestController
public class CargaInsumoController {

	@Autowired
	private InsumosService insumoService;
	
	@RequestMapping("/cargaInsumoMenu")
    public List<InsumoDto> comboMenue() {
        return insumoService.obtenerInsumosPorMenu(1l);
    }
}
