package ungs.bienestar.back.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.service.ReporteService;

@RestController
public class ReporteController {

	@Autowired
	private ReporteService reporteService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/comprasTotales")
	@PreAuthorize("hasAuthority('reportes')")
    public ResponseEntity<Resource> comprasTotales(HttpServletResponse response, @RequestParam Map<String, String> params) {
		Resource resource;
		try {
			resource = reporteService.exportReporte(params);
			return ResponseEntity.ok()
			        .header("Content-disposition", "attachment; filename=Compras_Totales.xlsx")
			        .contentLength(resource.contentLength())
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(resource);

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
}
