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
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboTipoMenue")
    public List<ComboDto> comboTipoMenue() {
        return comboService.tipoDeMenueItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboUnidadMedida")
    public List<ComboDto> comboUnidadMedida() {
        return comboService.unidadDeMedidaItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboCategoriaCompra")
    public List<ComboDto> comboCategoriaCompra() {
        return comboService.categoriaCompraItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboProveedores")
    public List<ComboDto> comboProveedores() {
        return comboService.proveedoresItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboLocalidades")
    public List<ComboDto> comboLocalidades() {
        return comboService.localidadesItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboFormaDePago")
    public List<ComboDto> comboFormaDePago() {
        return comboService.formaDePagoItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboInsumos")
    public List<ComboDto> comboInsumos() {
        return comboService.insumosItems();
    }
}
