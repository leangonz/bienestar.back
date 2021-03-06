package ungs.bienestar.back.factory;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Motivo;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.MotivoInvalidoException;
import ungs.bienestar.back.model.movimiento.MovimientoAjusteStock;
import ungs.bienestar.back.model.movimiento.MovimientoCompra;
import ungs.bienestar.back.model.movimiento.MovimientoConsumo;
import ungs.bienestar.back.model.movimiento.MovimientoMalEstado;
import ungs.bienestar.back.model.movimiento.MovimientoModel;
import ungs.bienestar.back.model.movimiento.MovimientoResiduos;
import ungs.bienestar.back.model.movimiento.MovimientoSobras;

@Component
public class MovimientoModelFactory {

	public Movimiento crearMovimientoConsumo(ConsumoDetalle consumoDetalle) {
		Movimiento movimiento = new Movimiento();
		movimiento.setCantidadAjustada(consumoDetalle.getCantidad());
		//TODO No tengo la fecha aca
		movimiento.setFecha(LocalDate.now());
		movimiento.setInsumo(consumoDetalle.getInsumo());
		movimiento.setMotivo(new Motivo(6l));
		
		return movimiento;
	}
	
	public MovimientoModel crearMovimiento(InsumoDto dto, Date fecha, Long motivo) throws MotivoInvalidoException {
		return this.crearMovimiento(dto.getId(), dto.getCantidad(), fecha, motivo);
	}
	
	public MovimientoModel crearMovimiento(Long idInsumo, Double cantidad, Date fecha, Long motivo) throws MotivoInvalidoException {
		if(motivo == 1) {
			return new MovimientoResiduos(idInsumo, cantidad, fecha, motivo);
		} else if (motivo == 2) {
			return new MovimientoMalEstado(idInsumo, cantidad, fecha, motivo);
		} else if (motivo == 3) {
			return new MovimientoSobras(idInsumo, cantidad, fecha, motivo);
		} else if (motivo == 4) {
			return new MovimientoAjusteStock(idInsumo, cantidad, fecha, motivo);
		} else if (motivo == 5) {
			return new MovimientoCompra(idInsumo, cantidad, fecha, motivo);
		} else if (motivo == 6) {
			return new MovimientoConsumo(idInsumo, cantidad, fecha, motivo);
		}
		throw new MotivoInvalidoException();
	}
}
