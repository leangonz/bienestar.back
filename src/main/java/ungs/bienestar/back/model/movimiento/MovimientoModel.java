package ungs.bienestar.back.model.movimiento;

import java.time.LocalDate;
import java.util.Date;

import ungs.bienestar.back.StaticContextHolder;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.entity.Motivo;
import ungs.bienestar.back.entity.Movimiento;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;
import ungs.bienestar.back.service.StockService;

public abstract class MovimientoModel {

	protected Double cantidad;
	protected Long idInsumo;
	protected Date fecha;
	protected Long motivo;
	protected StockService stockService;
	
	public MovimientoModel(Long idInsumo, Double cantidad, Date fecha, Long motivo) {
		super();
		this.idInsumo = idInsumo;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.motivo = motivo;
		this.stockService = StaticContextHolder.getBean(StockService.class);
	}

	public Movimiento crearMovimiento() {
		Movimiento movimiento = new Movimiento();
		movimiento.setCantidadAjustada(cantidad);
		//TODO No tengo la fecha aca
		movimiento.setFecha(LocalDate.now());
		//TODO buscar insumo
		movimiento.setInsumo(new Insumo(idInsumo));
		movimiento.setMotivo(new Motivo(motivo));
		
		return movimiento;
	}

	public abstract void actualizarStock(Movimiento movimiento) throws NotExistStockException, NegativeStockException;
}
