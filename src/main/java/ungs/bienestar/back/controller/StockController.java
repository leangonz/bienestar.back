package ungs.bienestar.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.AjusteStockDto;
import ungs.bienestar.back.dto.StockDto;
import ungs.bienestar.back.service.AjusteStockService;
import ungs.bienestar.back.service.StockService;

@RestController
public class StockController {

	@Autowired
	private AjusteStockService ajusteStockService;
	
	@Autowired
	private StockService stockService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ajustarStock")
	@PreAuthorize("hasAuthority('ajustarStock')")
    public Boolean ajustarStock(@RequestBody AjusteStockDto dto) {
		ajusteStockService.ajustarStock(dto);
        return true;
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/consultarStock")
	@PreAuthorize("hasAuthority('consultarStock')")
    public StockDto consultarStock(@RequestBody Long idInsumo) {
		return stockService.consultarStock(idInsumo);
    }
}
