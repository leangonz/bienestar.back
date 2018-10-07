package ungs.bienestar.back.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdenCompraTest {

	@Autowired
	private OrdenCompraRepository repository;
	
	@Test
	public void ordenCompraMappingTest(){
		repository.findAll();
	}
}
