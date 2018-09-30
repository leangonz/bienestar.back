package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.AjusteStockDto;
import ungs.bienestar.back.exception.LambdaExceptionWrapper;
import ungs.bienestar.back.factory.MovimientoModelFactory;
import ungs.bienestar.back.model.movimiento.MovimientoModel;

@Service
@Transactional
public class AjusteStockService {

	@Autowired
	private MovimientoService movimientoService;

	@Autowired
	private MovimientoModelFactory movimientoModelFactory;

	public void ajustarStock(AjusteStockDto dto) {
		List<MovimientoModel> models = dto.getInsumos().stream()
				.map(LambdaExceptionWrapper.wrapper(i -> movimientoModelFactory.crearMovimiento(i, dto.getFecha(), dto.getMotivo())))
				.collect(Collectors.toList());
		models.forEach(m -> movimientoService.generarMovimiento(m));
	}

}
