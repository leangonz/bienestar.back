package ungs.bienestar.back.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.CategoriaDto;
import ungs.bienestar.back.entity.Categoria;
import ungs.bienestar.back.entity.CategoriaId;
import ungs.bienestar.back.exception.Entity;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria obtenerUnidadMedidaBy(CategoriaId id) throws NotFoundException {
		//FIXME adaptar NOTFOUNDEXCEPTION para que acepte 2 ids
		return categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException(Entity.CATEGORIA, id.getIdCategoriaPrincipal()));
	}
	
	public List<CategoriaDto> categoriasItems() {
		return categoriaRepository.findAll().stream().map(m -> mapper(m))
				.collect(Collectors.toList());
	}
	
	private CategoriaDto mapper(Categoria categoria) {
		CategoriaDto dto = new CategoriaDto();
		dto.setIdCategoriaPrincipal(categoria.getId().getIdCategoriaPrincipal());
		dto.setIdCategoriaSecundaria(categoria.getId().getIdCategoriaSecundaria());
		dto.setDescripcion(categoria.getCategoriaSecundaria().getDescripcion());
		return dto;
	}

	public List<CategoriaDto> categoriasDeComedorItems() {
		return this.categoriasItems().stream().filter(m -> this.isCategoriaComedor(m.getIdCategoriaPrincipal())).collect(Collectors.toList());
	}
	
	//FIXME hacerlo mejor
	private Boolean isCategoriaComedor(Long id) {
		List<Long> motivosAjustables = Arrays.asList(5l);
		return motivosAjustables.contains(id);
	}

}
