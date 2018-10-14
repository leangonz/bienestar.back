package ungs.bienestar.back.factory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraItemDto;
import ungs.bienestar.back.entity.OrdenCompraDetalle;
import ungs.bienestar.back.entity.OrdenCompraHeader;
import ungs.bienestar.back.exception.ConsumerWithException;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.AreaService;
import ungs.bienestar.back.service.InsumosService;
import ungs.bienestar.back.service.ProveedorService;

@Component
public class OrdenCompraFactory {

	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private InsumosService insumoService;
	
	public OrdenCompraHeader crearOrdenCompra(CompraDto dto) throws NotFoundException {
		OrdenCompraHeader ordenCompra = new OrdenCompraHeader();
		//TODO falta categoria?
		ordenCompra.setFactura(dto.getFactura());
		ordenCompra.setFecha(dto.getFecha());
		ordenCompra.setProveedor(proveedorService.obtenerProveedorBy(dto.getProveedor()));
		ordenCompra.setArea(areaService.obtenerAreaBy(dto.getArea()));
		ordenCompra.setDetalle(new ArrayList<>());
		dto.getItems().forEach(ConsumerWithException.wrapper(item -> ordenCompra.addCompraItem(this.crearCompraDetalle(item))));
		return ordenCompra;
	}
	
	private OrdenCompraDetalle crearCompraDetalle(CompraItemDto itemDto) throws NotFoundException {
		OrdenCompraDetalle detalle = new OrdenCompraDetalle();
		detalle.setCantidad(itemDto.getCantidad());
		detalle.setPrecioUnitario(itemDto.getPrecioUnitario());
		detalle.setInsumo(insumoService.obtenerInsumoBy(itemDto.getInsumo()));
		return detalle;
	}
	
}
