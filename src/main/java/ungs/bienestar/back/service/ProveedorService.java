package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ProveedorDto;
import ungs.bienestar.back.entity.Proveedor;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.factory.ProveedorFactory;
import ungs.bienestar.back.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private ProveedorFactory proveedorFactory;
	
	public void crearProveedor(ProveedorDto dto) {
		Proveedor proveedor;
		try {
			proveedor = proveedorFactory.crearProveedor(dto);
			proveedorRepository.save(proveedor);
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void modificarProveedor(ProveedorDto dto) throws NotFoundException {
		Proveedor proveedor = this.obtenerProveedorBy(dto.getId());
		proveedorFactory.actualizarProveedor(dto, proveedor);
	}
	
	public Proveedor obtenerProveedorBy(Long id) throws NotFoundException {
		return proveedorRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.PROVEEDOR, id));
	}

	public ProveedorDto obtenerProveedorDtoBy(Long id) throws NotFoundException {
		return proveedorRepository.findById(id).map(x -> toDto(x)).orElseThrow(() -> new NotFoundException(Entity.PROVEEDOR, id));
	}
	
	public List<ProveedorDto> filtrarProveedor(Long filter) throws NotFoundException {
		return proveedorRepository.findByParams(filter).stream().map(x -> this.toDto(x)).collect(Collectors.toList());
	}
	
	private ProveedorDto toDto(Proveedor proveedor) {
		ProveedorDto dto = new ProveedorDto();
		dto.setId(proveedor.getIdProveedor());
		dto.setNombre(proveedor.getNombreProveedor());
		dto.setCuit(proveedor.getCuit());
		dto.setTelefono(proveedor.getTelefono());
		dto.setAltura(proveedor.getAltura());
		dto.setCalle(proveedor.getCalle());
		dto.setContacto(proveedor.getContacto());
		dto.setFormaDePago(proveedor.getFormaDePago().getIdFormaPago());
		dto.setLocalidad(proveedor.getCiudad().getCp());
		dto.setMail(proveedor.getMail());
		return dto;
	}

	public Boolean borrarProveedor(Long idProveedor) {
		proveedorRepository.findById(idProveedor).ifPresent(x -> x.setActivo(false));
		return true;
	}
}
