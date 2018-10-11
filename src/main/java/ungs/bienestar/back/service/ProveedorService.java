package ungs.bienestar.back.service;

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
	
	public Proveedor obtenerProveedorBy(Long id) throws NotFoundException {
		return proveedorRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.PROVEEDOR, id));
	}
}
