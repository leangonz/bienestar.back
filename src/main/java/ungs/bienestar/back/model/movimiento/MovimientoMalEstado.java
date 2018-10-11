package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;

public class MovimientoMalEstado extends MovimientoModel {

	public MovimientoMalEstado(Long idInsumo, Double cantidad, Date fecha, Long motivo) {
		super(idInsumo, cantidad, fecha, motivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarStock(Movimiento movimiento) throws NotExistStockException, NegativeStockException {
		stockService.disminuirStock(movimiento.getInsumo(), movimiento.getCantidadAjustada());
	}

}
