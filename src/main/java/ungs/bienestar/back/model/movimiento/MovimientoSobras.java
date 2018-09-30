package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;

public class MovimientoSobras extends MovimientoModel {

	public MovimientoSobras(InsumoDto dto, Date fecha, Long motivo) {
		super(dto, fecha, motivo);
	}

	@Override
	public void actualizarStock(Movimiento movimiento) throws NotExistStockException, NegativeStockException {
		//este movimiento no actualiza stock
	}

}
