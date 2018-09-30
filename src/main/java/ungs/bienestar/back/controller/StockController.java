package ungs.bienestar.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.AjusteStockDto;
import ungs.bienestar.back.service.AjusteStockService;

@RestController
public class StockController {

	@Autowired
	private AjusteStockService ajusteStockService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ajustarStock")
    public Boolean ajustarStock(@RequestBody AjusteStockDto dto) {
		ajusteStockService.ajustarStock(dto);
        return true;
    }
}
