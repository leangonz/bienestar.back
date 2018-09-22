package ungs.bienestar.back.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ungs.bienestar.back.entity.Menue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenueTest {

	@Autowired
	private MenueRepository repository;
	
	@Test
	public void mappingTestUsingFindAll(){
		repository.findAll();
	}
	
	@Test
	public void sieteMenues(){
		List<Menue> menues = repository.findAll();
		Assert.assertNotNull(menues);
		Assert.assertEquals(7, menues.size());
		Assert.assertEquals("Bizcochuelo", menues.get(0).getDescripcion());
		Assert.assertEquals("Galletitas", menues.get(1).getDescripcion());
		Assert.assertEquals("Pan Mermelada", menues.get(2).getDescripcion());
		Assert.assertEquals("Leche Chocolatada", menues.get(3).getDescripcion());
		Assert.assertEquals("Matecocido", menues.get(4).getDescripcion());
		Assert.assertEquals("Té con Leche", menues.get(5).getDescripcion());
		Assert.assertEquals("Yogurt", menues.get(6).getDescripcion());
	}
}
