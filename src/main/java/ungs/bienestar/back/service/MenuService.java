package ungs.bienestar.back.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.dto.PreparacionDto;
import ungs.bienestar.back.entity.Menue;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.LambdaExceptionWrapper;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.factory.MenuFactory;
import ungs.bienestar.back.repository.MenueRepository;

@Service
@Transactional
public class MenuService {

	@Autowired
	private MenuFactory menuFactory;
	
	@Autowired
	private MenueRepository menuRepository;
	
	@Autowired
	private InsumosService insumoService;
	
	public void crearMenu(PreparacionDto dto) {
		Menue menu =  menuFactory.crearMenu(dto);
		menuRepository.save(menu);
	}
	
	public void modificarMenu(Long id, List<InsumoDto> insumos) throws NotFoundException {
		Menue menu =  menuRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.MENU, id));
		menu.getInsumos().clear();
		menu.getInsumos().addAll(insumos.stream().map(LambdaExceptionWrapper.wrapper(i -> insumoService.obtenerInsumoBy(i.getId()))).collect(Collectors.toList()));
		menuRepository.save(menu);
	}
	
	public Menue obtenerMenue(Long id) throws NotFoundException {
		return menuRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.MENU, id));
	}
	
	public List<PreparacionDto> filtrarMenu(Long filter) throws NotFoundException {
		return menuRepository.findByParams(filter).stream().map(x -> this.toDto(x)).collect(Collectors.toList());
	}
	
	private PreparacionDto toDto(Menue menu) {
		PreparacionDto dto = new PreparacionDto();
		dto.setIdMenu(menu.getIdMenues());
		dto.setNombreMenu(menu.getDescripcion());
		dto.setDescTipo(menu.getTipoDeMenue().getDescripcion());
		return dto;
	}
}
