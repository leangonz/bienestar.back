package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.entity.OrdenCompraHeader;
import ungs.bienestar.back.exception.NotFoundException;

@Service
@Transactional
public class CompraService {

	@Autowired
	private OrdenCompraService ordenCompraService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	public void guardarCompra(CompraDto dto) throws NotFoundException {
		OrdenCompraHeader ordenCompra = ordenCompraService.guardarConsumo(dto);
		//ordenCompra.getDetalle().forEach(detalle -> movimientoService.generarMovimiento(detalle));
	}

}
