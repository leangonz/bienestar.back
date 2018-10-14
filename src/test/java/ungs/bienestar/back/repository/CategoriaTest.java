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
	public void diezCategorias(){
		List<Categoria> categorias = repository.findAll();
		Assert.assertNotNull(categorias);
		Assert.assertEquals(10, categorias.size());
//		Assert.assertEquals("Frescos", categorias.get(0).getDescripcion());
//		Assert.assertEquals("Carne", categorias.get(1).getDescripcion());
//		Assert.assertEquals("Almacén", categorias.get(2).getDescripcion());
//		Assert.assertEquals("Verdulería", categorias.get(3).getDescripcion());
//		Assert.assertEquals("E. Frizzados", categorias.get(4).getDescripcion());
//		Assert.assertEquals("E. Guardados", categorias.get(5).getDescripcion());
		Assert.assertEquals(5, categorias.get(0).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(1l, categorias.get(0).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(5l, categorias.get(1).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(2l, categorias.get(1).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(5l, categorias.get(2).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(3l, categorias.get(2).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(5l, categorias.get(3).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(4l, categorias.get(3).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(5l, categorias.get(4).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(5l, categorias.get(4).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(5l, categorias.get(5).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(6l, categorias.get(5).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(1l, categorias.get(6).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(7l, categorias.get(6).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(2l, categorias.get(7).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(8l, categorias.get(7).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(3l, categorias.get(8).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(9l, categorias.get(8).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
		Assert.assertEquals(4l, categorias.get(9).getCategoriaPrincipal().getIdCategoriaPrincipal().longValue());
		Assert.assertEquals(10l, categorias.get(9).getCategoriaSecundaria().getIdCategoriaSecundaria().longValue());
	}
}
