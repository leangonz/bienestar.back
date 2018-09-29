package ungs.bienestar.back.factory;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ungs.bienestar.back.entity.ConsumoDetalle;
import ungs.bienestar.back.entity.Motivo;
import ungs.bienestar.back.entity.Movimiento;

@Component
public class MovimientoFactory {

	public Movimiento crearMovimientoConsumo(ConsumoDetalle consumoDetalle) {
		Movimiento movimiento = new Movimiento();
		movimiento.setCantidadAjustada(consumoDetalle.getCantidad());
		//TODO No tengo la fecha aca
		movimiento.setFecha(LocalDate.now());
		movimiento.setInsumo(consumoDetalle.getInsumo());
		movimiento.setMotivo(new Motivo(6l));
		
		return movimiento;
	}
}
