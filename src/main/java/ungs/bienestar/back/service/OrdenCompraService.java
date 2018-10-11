package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CompraDto;
import ungs.bienestar.back.entity.OrdenCompraHeader;
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
	
	public OrdenCompraHeader guardarConsumo(CompraDto dto) throws NotFoundException {
		OrdenCompraHeader ordenCompra = ordenCompraFactory.crearOrdenCompra(dto);
		return ordenCompraRepository.save(ordenCompra);
	}
}
