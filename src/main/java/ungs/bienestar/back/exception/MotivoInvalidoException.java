package ungs.bienestar.back.exception;

public class MotivoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return String.format(Errors.MOTIVO_INVALIDO);
	}

}
