package ungs.bienestar.back.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ungs.bienestar.back.entity.Categoria;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaTest {

	@Autowired
	private CategoriaRepository repository;
	
	@Test
	public void categoriaMappingTest(){
		repository.findAll();
	}
	
	@Test
	public void seisCategorias(){
		List<Categoria> categorias = repository.findAll();
		Assert.assertNotNull(categorias);
		Assert.assertEquals(6, categorias.size());
		Assert.assertEquals("Frescos", categorias.get(0).getDescripcion());
		Assert.assertEquals("Carne", categorias.get(1).getDescripcion());
		Assert.assertEquals("Almacén", categorias.get(2).getDescripcion());
		Assert.assertEquals("Verdulería", categorias.get(3).getDescripcion());
		Assert.assertEquals("E. Frizzados", categorias.get(4).getDescripcion());
		Assert.assertEquals("E. Guardados", categorias.get(5).getDescripcion());
	}
}
