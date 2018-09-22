package ungs.bienestar.back.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.entity.Menue;
import ungs.bienestar.back.entity.UnidadDeMedida;
import ungs.bienestar.back.repository.MenueRepository;

@RunWith(MockitoJUnitRunner.class)
public class PrecargaInsumosTest {

	@Mock
	private MenueRepository menueRepository;
	
	@InjectMocks
	private InsumosService service;
	
	@Before
	public void setup(){
		when(menueRepository.findById(anyLong())).thenReturn(mockMenues());
	}
	
	@Test
	public void obtencionInsumos(){
		List<InsumoDto> insumos = service.obtenerInsumosPorMenu(1l);
		Assert.assertEquals(Long.valueOf(1), insumos.get(0).getId());
		Assert.assertEquals("Huevos", insumos.get(0).getDescripcion());
		Assert.assertEquals("Kilos", insumos.get(0).getUnidadDeMedida());
	}
	
	private Optional<Menue> mockMenues(){
		Menue menue = new Menue();
		List<Insumo> insumos = new ArrayList<>();
		Insumo insumo = new Insumo();
		insumo.setIdInsumos(1l);
		insumo.setDescripcion("Huevos");
		insumo.setUnidadDeMedida(new UnidadDeMedida(1l, "Kilos"));
		insumos.add(insumo);
		menue.setInsumos(insumos);
		return Optional.of(menue);
	}
}
