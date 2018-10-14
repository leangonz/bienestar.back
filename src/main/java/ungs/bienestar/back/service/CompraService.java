package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraItemDto;
import ungs.bienestar.back.dto.CompraResumenDto;
import ungs.bienestar.back.entity.OrdenCompraHeader;
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
		ordenCompraService.guardarCompra(dto);
		List<MovimientoModel> models = dto.getItems().stream()
				.map(LambdaExceptionWrapper.wrapper((CompraItemDto i) -> movimientoModelFactory.crearMovimiento(i.getInsumo(), i.getCantidad(), dto.getFecha(), 5l)))
				.collect(Collectors.toList());
		models.forEach(m -> movimientoService.generarMovimiento(m));
	}

	public List<CompraResumenDto> filtrarCompra(Long idProveedor) {
		List<CompraResumenDto> compras = ordenCompraService.obtenerOrdenDeCompra(idProveedor).stream().map(oc -> mapper(oc)).collect(Collectors.toList());
		return compras;
	}
	
	private CompraResumenDto mapper(OrdenCompraHeader compra) {
		CompraResumenDto dto = new CompraResumenDto();
		dto.setIdOC(compra.getIdOc());
		dto.setFactura(compra.getFactura());
		dto.setFecha(compra.getFecha());
		dto.setProveedor(compra.getProveedor().getNombreProveedor());
		//dto.setPrecioTotal(compra.get);
		return dto;
	}

}
