package ungs.bienestar.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.repository.MenueRepository;

@Service
@Transactional
public class InsumosService {

	@Autowired
	private MenueRepository menueRepository;
	
	public List<InsumoDto> obtenerInsumosPorMenu(Long idMenue){
		List<Insumo> menue = menueRepository.findById(idMenue).map(m -> m.getInsumos()).orElseGet(ArrayList::new);
		return menue.stream().map(i -> mapper(i)).collect(Collectors.toList());
	}
	
	private InsumoDto mapper(Insumo insumo) {
		InsumoDto dto = new InsumoDto();
		dto.setId(insumo.getIdInsumos());
		dto.setDescripcion(insumo.getDescripcion());
		dto.setUnidadDeMedida(insumo.getUnidadDeMedida().getDescripcion());
		return dto;
	}
}
