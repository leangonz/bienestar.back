package ungs.bienestar.back.exception;

public class NotExistStockException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String descripcion;

	public NotExistStockException(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String getMessage() {
		return String.format(Errors.STOCK_NOT_EXIST, descripcion);
	}
}
