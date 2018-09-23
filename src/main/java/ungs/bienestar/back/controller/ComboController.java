package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ComboDto;
import ungs.bienestar.back.service.ComboService;

@RestController
public class ComboController {

	@Autowired
	private ComboService comboService;
	
	@RequestMapping("/comboMenue")
    public List<ComboDto> comboMenue() {
        return comboService.menuesItems();
    }
	
	@RequestMapping("/comboMotivo")
    public List<ComboDto> comboMotivo() {
        return comboService.motivosItems();
    }
	
	@RequestMapping("/comboTipoMenue")
    public List<ComboDto> comboTipoMenue() {
        return comboService.tipoDeMenueItems();
    }
	
	@RequestMapping("/comboUnidadMedida")
    public List<ComboDto> comboUnidadMedida() {
        return comboService.unidadDeMedidaItems();
    }
}
