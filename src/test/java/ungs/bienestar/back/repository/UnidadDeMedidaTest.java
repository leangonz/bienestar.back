package ungs.bienestar.back.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ungs.bienestar.back.entity.UnidadDeMedida;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnidadDeMedidaTest {

	@Autowired
	private UnidadDeMedidaRepository repository;
	
	@Test
	public void mappingTestUsingFindAll(){
		repository.findAll();
	}
	
	@Test
	public void cincoUnidadesDeMedida(){
		List<UnidadDeMedida> unidadesDeMedida = repository.findAll();
		Assert.assertNotNull(unidadesDeMedida);
		Assert.assertEquals(5, unidadesDeMedida.size());
		Assert.assertEquals("Kilos", unidadesDeMedida.get(0).getDescripcion());
		Assert.assertEquals("Gramos", unidadesDeMedida.get(1).getDescripcion());
		Assert.assertEquals("Litros", unidadesDeMedida.get(2).getDescripcion());
		Assert.assertEquals("Unidades", unidadesDeMedida.get(3).getDescripcion());
		Assert.assertEquals("Latas", unidadesDeMedida.get(4).getDescripcion());
	}
}
