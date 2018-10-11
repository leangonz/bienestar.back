package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraItemDto;
import ungs.bienestar.back.exception.LambdaExceptionWrapper;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.factory.MovimientoModelFactory;
import ungs.bienestar.back.model.movimiento.MovimientoModel;

@Service
@Transactional
public class CompraService {

	@Autowired
	private OrdenCompraService ordenCompraService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	@Autowired
	private MovimientoModelFactory movimientoModelFactory;
	
	public void guardarCompra(CompraDto dto) throws NotFoundException {
		ordenCompraService.guardarConsumo(dto);
		List<MovimientoModel> models = dto.getItems().stream()
				.map(LambdaExceptionWrapper.wrapper((CompraItemDto i) -> movimientoModelFactory.crearMovimiento(i.getInsumo(), i.getCantidad(), dto.getFecha(), 5l)))
				.collect(Collectors.toList());
		models.forEach(m -> movimientoService.generarMovimiento(m));
	}

}
