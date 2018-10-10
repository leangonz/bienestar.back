package ungs.bienestar.back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.OrdenCompraDto;

@RestController
public class OrdenCompraController {

	@CrossOrigin(origins = "*")
	@RequestMapping("/cargarOrdenCompra")
    public Boolean cargarOrdenCompra(@RequestBody OrdenCompraDto dto) {
        return true;
    }
}
