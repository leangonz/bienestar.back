package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;
import ungs.bienestar.back.factory.MovimientoModelFactory;
import ungs.bienestar.back.model.movimiento.MovimientoModel;
import ungs.bienestar.back.repository.MovimientoRepository;

@Service
@Transactional
public class MovimientoService {

	private static Logger logger = LoggerFactory.getLogger(MovimientoService.class);
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private MovimientoModelFactory movimientoFactory;
	
	@Autowired
	private StockService stockService;
	
	public void generarMovimiento(ConsumoDetalle consumoDetalle) {
		Movimiento movimiento = movimientoFactory.crearMovimientoConsumo(consumoDetalle);
		movimientoRepository.save(movimiento);
		try {
			stockService.disminuirStock(consumoDetalle.getInsumo(), consumoDetalle.getCantidad());
		} catch (NotExistStockException | NegativeStockException e) {
			// TODO que hacer en ambos casos?
			logger.error(e.getMessage());
		}
	}

	public void generarMovimiento(MovimientoModel model) {
		Movimiento movimiento = model.crearMovimiento();
		movimientoRepository.save(movimiento);
		try {
			model.actualizarStock(movimiento);
		} catch (NotExistStockException | NegativeStockException e) {
			// TODO que hacer en ambos casos?
			logger.error(e.getMessage());
		}
	}

}
