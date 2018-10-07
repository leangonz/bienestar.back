package ungs.bienestar.back.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ungs.bienestar.back.entity.TipoDeMenue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoDeMenueTest {

	@Autowired
	private TipoDeMenueRepository repository;
	
	@Test
	public void mappingTestUsingFindAll(){
		repository.findAll();
	}
	
	@Test
	public void seisTiposMenue(){
		List<TipoDeMenue> tiposMenue = repository.findAll();
		Assert.assertNotNull(tiposMenue);
		Assert.assertEquals(6, tiposMenue.size());
		Assert.assertEquals("Colación", tiposMenue.get(0).getDescripcion());
		Assert.assertEquals("Infusión", tiposMenue.get(1).getDescripcion());
		Assert.assertEquals("Principal", tiposMenue.get(2).getDescripcion());
		Assert.assertEquals("Guarnición", tiposMenue.get(3).getDescripcion());
		Assert.assertEquals("Salsas", tiposMenue.get(4).getDescripcion());
		Assert.assertEquals("Postre", tiposMenue.get(5).getDescripcion());
	}
}
