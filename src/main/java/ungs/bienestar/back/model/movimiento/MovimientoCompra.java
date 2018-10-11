package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;

public class MovimientoCompra extends MovimientoModel {

	public MovimientoCompra(Long idInsumo, Double cantidad, Date fecha, Long motivo) {
		super(idInsumo, cantidad, fecha, motivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarStock(Movimiento movimiento) throws NotExistStockException, NegativeStockException {
		stockService.aumentarStock(movimiento.getInsumo(), movimiento.getCantidadAjustada());
	}

}
