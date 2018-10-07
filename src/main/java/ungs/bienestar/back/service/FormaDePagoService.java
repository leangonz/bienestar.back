package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.FormaDePago;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.FormaDePagoRepository;

@Service
@Transactional
public class FormaDePagoService {

	@Autowired
	private FormaDePagoRepository formaDePagoRepository;
	
	public FormaDePago obtenerFormaDePagoBy(Long id) throws NotFoundException {
		return formaDePagoRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.FORMA_DE_PAGO, id));
	}
}
