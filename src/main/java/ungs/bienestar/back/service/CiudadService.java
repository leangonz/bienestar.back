package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.Ciudad;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.CiudadRepository;

@Service
@Transactional
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	public Ciudad obtenerFormaDePagoBy(Long id) throws NotFoundException {
		return ciudadRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.CIUDAD, id));
	}
}
