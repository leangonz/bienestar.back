package ungs.bienestar.back.service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.ComboDto;
import ungs.bienestar.back.repository.MenueRepository;
import ungs.bienestar.back.repository.MotivoRepository;
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
	
	private ComboDto mapper(Supplier<Long> getId, Supplier<String> getDescripcion) {
		ComboDto item = new ComboDto();
		item.setId(getId.get());
		item.setDescripcion(getDescripcion.get());
		return item;
	}

}
