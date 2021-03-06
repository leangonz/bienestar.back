package ungs.bienestar.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.factory.InsumoFactory;
import ungs.bienestar.back.repository.InsumoRepository;
import ungs.bienestar.back.repository.MenueRepository;

@Service
@Transactional
public class InsumosService {

	@Autowired
	private MenueRepository menueRepository;

	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoFactory insumoFactory;

	@Autowired
	private CategoriaService categoriaService;
	
	public List<InsumoDto> obtenerInsumosPorMenu(Long idMenue) {
		List<Insumo> menue = menueRepository.findById(idMenue).map(m -> m.getInsumos()).orElseGet(ArrayList::new);
		return menue.stream().filter(x-> x.getActivo()).map(i -> mapper(i)).collect(Collectors.toList());
	}

	public List<InsumoDto> obtenerInsumos() {
		return insumoRepository.findAll().stream().filter(x-> x.getActivo()).map(i -> mapper(i)).collect(Collectors.toList());
	}

	public Insumo obtenerInsumoBy(Long id) throws NotFoundException {
		return insumoRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.INSUMO, id));
	}

	public InsumoDto obtenerInsumoDtoBy(Long id) throws NotFoundException {
		return insumoRepository.findById(id).map(x -> mapper(x)).orElseThrow(() -> new NotFoundException(Entity.INSUMO, id));
	}
	
	public void crearInsumo(InsumoDto dto) {
		Insumo insumo =  insumoFactory.crearInsumo(dto);
		insumoRepository.save(insumo);
	}
	
	public void modificarInsumo(InsumoDto dto) throws NotFoundException {
		Insumo insumo = this.obtenerInsumoBy(dto.getId());
		insumoFactory.actualizarInsumo(dto, insumo);
	}
	
	public InsumoDto mapper(Insumo insumo) {
		InsumoDto dto = new InsumoDto();
		dto.setId(insumo.getIdInsumos());
		dto.setDescripcion(insumo.getDescripcion());
		dto.setUnidadDeMedida(insumo.getUnidadDeMedida().getDescripcion());
		dto.setCategoria(categoriaService.mapper(insumo.getCategoria()));
		dto.setIdUnidadMedida(insumo.getUnidadDeMedida().getIdUnidadMedida());
		return dto;
	}

	public List<InsumoDto> mapper(List<Insumo> insumos){
		return insumos.stream().map(x -> this.mapper(x)).collect(Collectors.toList());
	}
	
	public List<InsumoDto> filtrarInsumos(Long filter) throws NotFoundException {
		return insumoRepository.findByParams(filter).stream().map(x -> this.mapper(x)).collect(Collectors.toList());
	}
	
	public Boolean borrarProveedor(Long idInsumo) {
		insumoRepository.findById(idInsumo).ifPresent(x -> x.setActivo(false));
		return true;
	}
}
