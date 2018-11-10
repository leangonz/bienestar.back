package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboMenue() {
        return comboService.menuesItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboMotivo")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboMotivo() {
        return comboService.motivosItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboMotivosAjustables")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboMotivosAjustables() {
        return comboService.motivoAjustableItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboTipoMenue")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboTipoMenue() {
        return comboService.tipoDeMenueItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboUnidadMedida")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboUnidadMedida() {
        return comboService.unidadDeMedidaItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboCategoriaCompra")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboCategoriaCompra() {
        return comboService.categoriaCompraItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboProveedores")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboProveedores() {
        return comboService.proveedoresItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboLocalidades")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboLocalidades() {
        return comboService.localidadesItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboFormaDePago")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboFormaDePago() {
        return comboService.formaDePagoItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboInsumos")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboInsumos() {
        return comboService.insumosItems();
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/comboAreas")
	@PreAuthorize("isAuthenticated()")
    public List<ComboDto> comboAreas() {
        return comboService.areaItems();
    }
}
