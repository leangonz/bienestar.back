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

@Component
public class ConsumoFactory {

	@Autowired
	private InsumosService insumoService;

	public Consumo crearConsumo(ConsumoRealizadoDto consumoRealizado) {
		Consumo consumo = new Consumo();
		consumo.setFecha(LocalDate.now());
		consumo.setCantidadLactario(consumoRealizado.getLactarios());
		consumo.setCantidadUnAnio(consumoRealizado.getUnAnio());
		consumo.setCantidadDosAnios(consumoRealizado.getDosAnios());
		consumo.setCantidadTresAnios(consumoRealizado.getTresAnios());
		consumo.setCantidadCuatroCincoAnios(consumoRealizado.getCuatroCincoAnios());
		consumo.setCantidadAdultos(consumoRealizado.getAdultos());
		consumo.setConsumosDetalle(new ArrayList<>());
		consumoRealizado.getInsumos().forEach(ConsumerWithException.wrapper(insumo -> consumo.addConsumoDetalle(this.crearConsumoDetalle(insumo))));
		consumo.setUsuario(new Usuario(1l));
		return consumo;
	}

	private ConsumoDetalle crearConsumoDetalle(InsumoDto insumo) throws NotFoundException {
		ConsumoDetalle detalle = new ConsumoDetalle();
		detalle.setInsumo(insumoService.obtenerInsumoBy(insumo.getId()));
		detalle.setCantidad(insumo.getCantidad());
		detalle.setMenue(new Menue(1l));
		return detalle;
	}

}
