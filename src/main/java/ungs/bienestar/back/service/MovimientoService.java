package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.MovimientoDto;
import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;
import ungs.bienestar.back.exception.NotFoundException;
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

	public List<MovimientoDto> filtrarMovimientos(Long filter) throws NotFoundException {
		return movimientoRepository.findByParams(filter).stream().map(x -> this.toDto(x)).collect(Collectors.toList());
	}
	
	private MovimientoDto toDto(Movimiento movimiento) {
		MovimientoDto dto = new MovimientoDto();
		dto.setCantidad(movimiento.getCantidadAjustada().toString());
		dto.setFecha(movimiento.getFecha().toString());
		dto.setInsumo(movimiento.getInsumo().getDescripcion());
		dto.setMotivo(movimiento.getMotivo().getDescripcion());
		dto.setUnidadDeMedida(movimiento.getInsumo().getUnidadDeMedida().getDescripcion());
		return dto;
	}
}
