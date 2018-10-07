package ungs.bienestar.back.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ComboDto;
import ungs.bienestar.back.repository.CategoriaCompraRepository;
import ungs.bienestar.back.repository.CiudadRepository;
import ungs.bienestar.back.repository.FormaDePagoRepository;
import ungs.bienestar.back.repository.MenueRepository;
import ungs.bienestar.back.repository.MotivoRepository;
import ungs.bienestar.back.repository.ProveedorRepository;
import ungs.bienestar.back.repository.TipoDeMenueRepository;
import ungs.bienestar.back.repository.UnidadDeMedidaRepository;

@Service
@Transactional
public class ComboService {

	@Autowired
	private MenueRepository menueRepository;

	@Autowired
	private MotivoRepository motivoRepository;

	@Autowired
	private TipoDeMenueRepository tipoDeMenueRepository;
	
	@Autowired
	private UnidadDeMedidaRepository unidadDeMedidaRepository;
	
	@Autowired
	private CategoriaCompraRepository categoriaCompraRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private FormaDePagoRepository formaDePagoRepository;
	
	public List<ComboDto> menuesItems() {
		return menueRepository.findAll().stream().map(m -> mapper(m::getIdMenues, m::getDescripcion))
				.collect(Collectors.toList());
	}

	public List<ComboDto> motivosItems() {
		return motivoRepository.findAll().stream().map(m -> mapper(m::getIdMotivos, m::getDescripcion))
				.collect(Collectors.toList());
	}

	public List<ComboDto> tipoDeMenueItems() {
		return tipoDeMenueRepository.findAll().stream().map(m -> mapper(m::getIdTiposMenues, m::getDescripcion))
				.collect(Collectors.toList());
	}
	
	public List<ComboDto> unidadDeMedidaItems() {
		return unidadDeMedidaRepository.findAll().stream().map(m -> mapper(m::getIdUnidadMedida, m::getDescripcion))
				.collect(Collectors.toList());
	}
	
	public List<ComboDto> motivoAjustableItems() {
		return this.motivosItems().stream().filter(m -> this.isMotivoAjustable(m.getId())).collect(Collectors.toList());
	}
	
	//FIXME hacerlo mejor
	private Boolean isMotivoAjustable(Long idMotivo) {
		List<Long> motivosAjustables = Arrays.asList(1l,2l,3l,4l);
		return motivosAjustables.contains(idMotivo);
	}

	public List<ComboDto> categoriaCompraItems() {
		return categoriaCompraRepository.findAll().stream().map(m -> mapper(m::getIdCategoriaCompra, m::getCategoria))
				.collect(Collectors.toList());
	}

	public List<ComboDto> proveedoresItems() {
		return proveedorRepository.findAll().stream().map(m -> mapper(m::getIdProveedor, m::getNombreProveedor))
				.collect(Collectors.toList());
	}

	public List<ComboDto> localidadesItems() {
		return ciudadRepository.findAll().stream().map(m -> mapper(m::getCp, m::getNombre))
				.collect(Collectors.toList());
	}

	public List<ComboDto> formaDePagoItems() {
		return formaDePagoRepository.findAll().stream().map(m -> mapper(m::getIdFormaPago, m::getDescripcion))
				.collect(Collectors.toList());
	}
	
	private ComboDto mapper(Supplier<Long> getId, Supplier<String> getDescripcion) {
		ComboDto item = new ComboDto();
		item.setId(getId.get());
		item.setDescripcion(getDescripcion.get());
		return item;
	}
}
