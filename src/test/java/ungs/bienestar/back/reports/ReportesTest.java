package ungs.bienestar.back.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ungs.bienestar.back.factory.ReportesFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportesTest {

	@Autowired
	private ReportesFactory reportesFactory;
	
	@Test
	public void getInstanciaReporteCompra() {
		Report reporte = reportesFactory.obtenerReporteTemplate(Report.COMPRAS_TOTALES);
		Assert.assertThat(reporte, IsInstanceOf.instanceOf(ComprasTotalesReport.class));
	}
	
	@Test
	public void headersReporteCompra() {
		Report reporte = reportesFactory.obtenerReporteTemplate(Report.COMPRAS_TOTALES);
		Assert.assertEquals(reporte.header().getCells().size(), 13);
		Assert.assertEquals(reporte.header().getCells().get(0), "Categoria");
		Assert.assertEquals(reporte.header().getCells().get(1), "Enero");
		Assert.assertEquals(reporte.header().getCells().get(2), "Febrero");
		Assert.assertEquals(reporte.header().getCells().get(3), "Marzo");
		Assert.assertEquals(reporte.header().getCells().get(4), "Abril");
		Assert.assertEquals(reporte.header().getCells().get(5), "Mayo");
		Assert.assertEquals(reporte.header().getCells().get(6), "Junio");
		Assert.assertEquals(reporte.header().getCells().get(7), "Julio");
		Assert.assertEquals(reporte.header().getCells().get(8), "Agosto");
		Assert.assertEquals(reporte.header().getCells().get(9), "Septiembre");
		Assert.assertEquals(reporte.header().getCells().get(10), "Octubre");
		Assert.assertEquals(reporte.header().getCells().get(11), "Noviembre");
		Assert.assertEquals(reporte.header().getCells().get(12), "Diciembre");
	}
	
	@Test
	public void filtersReporteCompra() {
		Report reporte = reportesFactory.obtenerReporteTemplate(Report.COMPRAS_TOTALES);
		Assert.assertEquals(reporte.filters().size(), 1);
		Assert.assertEquals(reporte.filters().get(0), "anio");
	}
	
	@Test
	public void bodyReporteCompra() {
		Report reporte = reportesFactory.obtenerReporteTemplate(Report.COMPRAS_TOTALES);
		Map<String, String> filters = new HashMap<>();
		filters.put("anio", "2018");
		List<Fila> s = reporte.body(filters);
		System.out.println(s);
	}
}
