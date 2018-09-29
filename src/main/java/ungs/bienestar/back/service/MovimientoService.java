package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.factory.MovimientoFactory;
import ungs.bienestar.back.repository.MovimientoRepository;

@Service
@Transactional
public class MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private MovimientoFactory movimientoFactory;
	
	public void generarMovimiento(ConsumoDetalle consumoDetalle) {
		Movimiento movimiento = movimientoFactory.crearMovimientoConsumo(consumoDetalle);
		movimientoRepository.save(movimiento);
		//decidir si se actualiza stock de acuerdo al movimiento
	}

}
