package ungs.bienestar.back.factory;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.ConsumoRealizadoDto;
import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Consumo;
import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Menue;
import ungs.bienestar.back.entity.Usuario;
import ungs.bienestar.back.exception.ConsumerWithException;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.InsumosService;
import ungs.bienestar.back.service.MomentoDelDiaService;

@Component
public class ConsumoFactory {

	@Autowired
	private InsumosService insumoService;
	
	@Autowired
	private MomentoDelDiaService momentoDelDiaService;

	public Consumo crearConsumo(ConsumoRealizadoDto consumoRealizado) {
		try {
			Consumo consumo = new Consumo();
			consumo.setFecha(LocalDate.now());
			consumo.setCantidadLactario(consumoRealizado.getLactarios());
			consumo.setCantidadUnAnio(consumoRealizado.getUnAnio());
			consumo.setCantidadDosAnios(consumoRealizado.getDosAnios());
			consumo.setCantidadTresAnios(consumoRealizado.getTresAnios());
			consumo.setCantidadCuatroCincoAnios(consumoRealizado.getCuatroCincoAnios());
			consumo.setCantidadAdultos(consumoRealizado.getAdultos());
			consumo.setConsumosDetalle(new ArrayList<>());
			consumo.setMomentoDelDia(momentoDelDiaService.obtenerMomentoDelDia(consumoRealizado.getMomentoDelDia()));
			consumoRealizado.getInsumos().forEach(ConsumerWithException.wrapper(insumo -> consumo.addConsumoDetalle(this.crearConsumoDetalle(insumo))));
			//TODO no estoy obteniendo el usuario logeado
			consumo.setUsuario(new Usuario(1l));
			return consumo;
		} catch (NotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private ConsumoDetalle crearConsumoDetalle(InsumoDto insumo) throws NotFoundException {
		ConsumoDetalle detalle = new ConsumoDetalle();
		detalle.setInsumo(insumoService.obtenerInsumoBy(insumo.getId()));
		detalle.setCantidad(insumo.getCantidad());
		//TODO no estoy recibiendo el menu
		detalle.setMenue(new Menue(1l));
		return detalle;
	}

}
