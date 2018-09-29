package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ConsumoRealizadoDto;
import ungs.bienestar.back.entity.Consumo;

@Service
@Transactional
public class ComidaService {

	@Autowired
	private ConsumoService consumoService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	public void guardarComida(ConsumoRealizadoDto dto) {
		Consumo consumo = consumoService.guardarConsumo(dto);
		consumo.getConsumosDetalle().forEach(detalle -> movimientoService.generarMovimiento(detalle));
	}
}
