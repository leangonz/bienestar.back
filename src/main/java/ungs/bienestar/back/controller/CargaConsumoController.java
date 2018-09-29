package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ConsumoRealizadoDto;
import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.service.ComidaService;
import ungs.bienestar.back.service.InsumosService;

@RestController
public class CargaConsumoController {

	@Autowired
	private InsumosService insumoService;
	
	@Autowired
	private ComidaService comidaService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/cargaInsumoMenu")
    public List<InsumoDto> cargaInsumoMenu(@RequestBody Long idMenu) {
        return insumoService.obtenerInsumosPorMenu(idMenu);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/cargaInsumo")
	public List<InsumoDto> cargaInsumo() {
		return insumoService.obtenerInsumos();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/guardarConsumoRealizado")
	public Boolean guardarConsumoRealizado(@RequestBody ConsumoRealizadoDto dto){
		comidaService.guardarComida(dto);
		return true;
	}
}
