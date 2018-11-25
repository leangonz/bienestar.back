package ungs.bienestar.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.ProveedorDto;
import ungs.bienestar.back.dto.ProveedorFilterDto;
import ungs.bienestar.back.exception.NotFoundException;
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
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/filtrarProveedor")
	@PreAuthorize("hasAuthority('abmProveedor')")
    public List<ProveedorDto> filtrarCompra(@RequestBody ProveedorFilterDto filter) throws NotFoundException {
		return proveedorService.filtrarProveedor(filter.getIdProveedor());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/borrarProveedor")
	@PreAuthorize("hasAuthority('abmProveedor')")
    public Boolean borrarProveedor(@RequestBody ProveedorFilterDto id) throws NotFoundException {
		return proveedorService.borrarProveedor(id.getIdProveedor());
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/buscarProveedor")
	@PreAuthorize("hasAuthority('abmProveedor')")
    public ProveedorDto buscarProveedor(@RequestBody ProveedorFilterDto id) throws NotFoundException {
		return proveedorService.obtenerProveedorDtoBy(id.getIdProveedor());
    }
	
}
