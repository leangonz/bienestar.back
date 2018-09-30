package ungs.bienestar.back.model.movimiento;

import java.time.LocalDate;
import java.util.Date;

import ungs.bienestar.back.dto.InsumoDto;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.entity.Motivo;
import ungs.bienestar.back.entity.Movimiento;

public abstract class MovimientoModel {

	protected InsumoDto dto;
	protected Date fecha;
	protected Long motivo;
	
	public MovimientoModel(InsumoDto dto, Date fecha, Long motivo) {
		super();
		this.dto = dto;
		this.fecha = fecha;
		this.motivo = motivo;
	}

	public Movimiento crearMovimiento() {
		Movimiento movimiento = new Movimiento();
		movimiento.setCantidadAjustada(dto.getCantidad());
		//TODO No tengo la fecha aca
		movimiento.setFecha(LocalDate.now());
		//TODO buscar insumo
		movimiento.setInsumo(new Insumo(dto.getId()));
		movimiento.setMotivo(new Motivo(motivo));
		
		return movimiento;
	}

	public abstract void actualizarStock();
}
