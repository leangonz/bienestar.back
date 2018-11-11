package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.MomentoDelDia;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.MomentoDelDiaRepository;

@Service
@Transactional
public class MomentoDelDiaService {

	@Autowired
	private MomentoDelDiaRepository momentoDelDiaRepository;

	
	public MomentoDelDia obtenerMomentoDelDia(Long id) throws NotFoundException {
		return momentoDelDiaRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.MOMENTO_DEL_DIA, id));
	}
}
