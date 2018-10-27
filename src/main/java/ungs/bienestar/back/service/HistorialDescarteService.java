package ungs.bienestar.back.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.DescarteDto;
import ungs.bienestar.back.entity.HistorialDescarte;
import ungs.bienestar.back.factory.HistorialDescarteFactory;
import ungs.bienestar.back.repository.HistorialDescarteRepository;

@Service
@Transactional
public class HistorialDescarteService {

	@Autowired
	private HistorialDescarteRepository historialDescarteRepository;
	
	@Autowired
	private HistorialDescarteFactory historialFactory;
	
	public void registrarHistorial(DescarteDto descarte) {
		List<HistorialDescarte> historiales = historialFactory.crearHistorialDescarte(descarte);
		historiales.forEach(x -> historialDescarteRepository.save(x));
	}
}
