package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.dto.InsumoDto;

public class MovimientoSobras extends MovimientoModel {

	public MovimientoSobras(InsumoDto dto, Date fecha, Long motivo) {
		super(dto, fecha, motivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarStock() {
		// TODO Auto-generated method stub

	}

}
