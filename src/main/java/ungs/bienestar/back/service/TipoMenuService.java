package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.TipoDeMenue;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.TipoDeMenueRepository;

@Service
@Transactional
public class TipoMenuService {

	@Autowired
	private TipoDeMenueRepository tipoMenuRepository;
	
	public TipoDeMenue obtenerTipoMenuBy(Long id) throws NotFoundException {
		return tipoMenuRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.TIPO_MENU, id));
	}
}
