package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ComboDto;
import ungs.bienestar.back.service.ComboService;

@RestController
public class ComboController {

	@Autowired
	private ComboService comboService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboMenue")
    public List<ComboDto> comboMenue() {
        return comboService.menuesItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboMotivo")
    public List<ComboDto> comboMotivo() {
        return comboService.motivosItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboMotivosAjustables")
    public List<ComboDto> comboMotivosAjustables() {
        return comboService.motivoAjustableItems();
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
