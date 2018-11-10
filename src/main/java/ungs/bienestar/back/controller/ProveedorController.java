package ungs.bienestar.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ProveedorDto;
import ungs.bienestar.back.service.ProveedorService;

@RestController
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/crearProveedor")
	@PreAuthorize("hasAuthority('abmProveedor')")
    public Boolean crearProveedor(@RequestBody ProveedorDto dto) {
		proveedorService.crearProveedor(dto);
        return true;
    }
}
