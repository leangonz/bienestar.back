package ungs.bienestar.back.model.movimiento;

import java.util.Date;

import ungs.bienestar.back.dto.InsumoDto;

public class MovimientoResiduos extends MovimientoModel {

	
	public MovimientoResiduos(InsumoDto dto, Date fecha, Long motivo) {
		super(dto, fecha, motivo);
	}

	@Override
	public void actualizarStock() {
		// TODO Auto-generated method stub
		
	}

}
