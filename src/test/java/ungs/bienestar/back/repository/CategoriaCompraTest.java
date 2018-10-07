package ungs.bienestar.back.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaCompraTest {

	@Autowired
	private CategoriaCompraRepository repository;
	
	@Test
	public void categoriaCompraMappingTest(){
		repository.findAll();
	}
}
