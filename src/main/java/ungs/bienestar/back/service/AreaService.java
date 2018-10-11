package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.Area;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.AreaRepository;

@Service
@Transactional
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	public Area obtenerAreaBy(Long id) throws NotFoundException {
		return areaRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.AREA, id));
	}
}
