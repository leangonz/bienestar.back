package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.dto.InsumoDto;

public class MovimientoConsumo extends MovimientoModel {

	public MovimientoConsumo(InsumoDto dto, Date fecha, Long motivo) {
		super(dto, fecha, motivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizarStock() {
		// TODO Auto-generated method stub

	}

}
