package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.dto.CompraFilterDto;
import ungs.bienestar.back.dto.CompraItemDto;
import ungs.bienestar.back.entity.OrdenCompraDetalle;
import ungs.bienestar.back.entity.OrdenCompraHeader;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.factory.OrdenCompraFactory;
import ungs.bienestar.back.repository.OrdenCompraRepository;

@Service
@Transactional
public class OrdenCompraService {

	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	@Autowired
	private OrdenCompraFactory ordenCompraFactory;
	
	public OrdenCompraHeader guardarCompra(CompraDto dto) throws NotFoundException {
		OrdenCompraHeader ordenCompra = ordenCompraFactory.crearOrdenCompra(dto);
		return ordenCompraRepository.save(ordenCompra);
	}

	public List<OrdenCompraHeader> obtenerOrdenDeCompra(CompraFilterDto dto) {
		return ordenCompraRepository.findByParams(dto.getIdProveedor(), dto.getFactura());
	}
	
	public CompraDto obtenerCompraDtoBy(Long id) throws NotFoundException {
		return ordenCompraRepository.findById(id).map(x -> toDto(x)).orElseThrow(() -> new NotFoundException(Entity.ORDEN_COMPRA, id));
	}
	
	private CompraDto toDto(OrdenCompraHeader header) {
		CompraDto dto = new CompraDto();
		dto.setArea(header.getArea().getIdArea());
		dto.setFactura(header.getFactura());
		dto.setFecha(header.getFecha());
		dto.setProveedor(header.getProveedor().getIdProveedor());
		dto.setDescProveedor(header.getProveedor().getNombreProveedor());
		dto.setItems(header.getDetalle().stream().map(x -> toDto(x)).collect(Collectors.toList()));
		return dto;
	}
	
	private CompraItemDto toDto(OrdenCompraDetalle detalle) {
		CompraItemDto dto = new CompraItemDto();
		dto.setCantidad(detalle.getCantidad());
		dto.setInsumo(detalle.getInsumo().getIdInsumos());
		dto.setDescripcion(detalle.getInsumo().getDescripcion());
		dto.setPrecioUnitario(detalle.getPrecioUnitario());
		dto.setPrecioTotal(detalle.getCantidad() * detalle.getPrecioUnitario());
		return dto;
	}
}
