package ungs.bienestar.back.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.CategoriaId;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.CategoriaService;
import ungs.bienestar.back.service.UnidadDeMedidaService;

@Component
public class InsumoFactory {

	@Autowired
	private UnidadDeMedidaService unidadMedidaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Insumo crearInsumo(InsumoDto dto) {
		try {
			Insumo insumo = new Insumo();
			insumo.setDescripcion(dto.getDescripcion());
			insumo.setUnidadDeMedida(unidadMedidaService.obtenerUnidadMedidaBy(dto.getIdUnidadMedida()));
			CategoriaId id = new CategoriaId(dto.getCategoria().getIdCategoriaPrincipal(), dto.getCategoria().getIdCategoriaSecundaria());
			insumo.setCategoria(categoriaService.obtenerUnidadMedidaBy(id));
			insumo.setActivo(true);
			return insumo;
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Insumo actualizarInsumo(InsumoDto origen, Insumo destino) throws NotFoundException {
		destino.setUnidadDeMedida(unidadMedidaService.obtenerUnidadMedidaBy(origen.getIdUnidadMedida()));
		CategoriaId id = new CategoriaId(origen.getCategoria().getIdCategoriaPrincipal(), origen.getCategoria().getIdCategoriaSecundaria());
		destino.setCategoria(categoriaService.obtenerUnidadMedidaBy(id));
		return destino;
	}
}
