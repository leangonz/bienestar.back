package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ConsumoRealizadoDto;

@Service
@Transactional
public class ComidaService {

	@Autowired
	private ConsumoService consumoServie;
	
	@Autowired
	private MovimientoService movimientoService;
	
	public void guardarComida(ConsumoRealizadoDto dto) {
		consumoServie.guardarConsumo(dto);
		movimientoService.generarMovimiento();
	}
}
