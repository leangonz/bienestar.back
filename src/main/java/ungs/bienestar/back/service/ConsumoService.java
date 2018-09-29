package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ConsumoRealizadoDto;
import ungs.bienestar.back.entity.Consumo;
import ungs.bienestar.back.factory.ConsumoFactory;
import ungs.bienestar.back.repository.ConsumoRepository;

@Service
@Transactional
public class ConsumoService {

	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ConsumoFactory consumoFactory;
	
	public Consumo guardarConsumo(ConsumoRealizadoDto dto) {
		Consumo consumo = consumoFactory.crearConsumo(dto);
		return consumoRepository.save(consumo);
	}
}
