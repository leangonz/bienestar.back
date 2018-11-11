package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.UnidadDeMedida;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.UnidadDeMedidaRepository;

@Service
@Transactional
public class UnidadDeMedidaService {

	@Autowired
	private UnidadDeMedidaRepository unidadMedidaRepository;
	
	public UnidadDeMedida obtenerUnidadMedidaBy(Long id) throws NotFoundException {
		return unidadMedidaRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.UNIDAD_MEDIDA, id));
	}
}
