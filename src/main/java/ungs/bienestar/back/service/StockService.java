package ungs.bienestar.back.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungs.bienestar.back.dto.AjusteStockDto;
import ungs.bienestar.back.entity.Insumo;
import ungs.bienestar.back.entity.Stock;
import ungs.bienestar.back.exception.NegativeStockException;
import ungs.bienestar.back.exception.NotExistStockException;
import ungs.bienestar.back.repository.StockRepository;

@Service
@Transactional
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public Stock crearStock(Insumo insumo) {
		Stock stock = new Stock();
		return stock;
	}
	
	public void aumentarStock(Insumo insumo, Double cantidad) {
		Stock stock = stockRepository.findById(insumo.getIdInsumos()).orElseGet(() -> this.crearStock(insumo));
		stock.setCantidad(stock.getCantidad() + cantidad);
		stockRepository.save(stock);
	}
	
	public void disminuirStock(Insumo insumo, Double cantidad) throws NotExistStockException, NegativeStockException {
		Stock stock = stockRepository.findById(insumo.getIdInsumos()).orElseThrow(() -> new NotExistStockException(insumo.getDescripcion()));
		this.validarSiSePuedeAjustar(stock, cantidad);
		stock.setCantidad(stock.getCantidad() - cantidad);
		stockRepository.save(stock);
	}
	
	private void validarSiSePuedeAjustar(Stock stock, Double cantidadADisminuir) throws NegativeStockException {
		if((stock.getCantidad() - cantidadADisminuir) < 0) {
			throw new NegativeStockException();
		}
	}

	public void ajustarStock(AjusteStockDto dto) {
		// TODO Auto-generated method stub
		
	}
	
}
