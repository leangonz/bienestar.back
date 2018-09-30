package ungs.bienestar.back.exception;

public class NotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Entity entity;
	
	private Long id;
	
	public NotFoundException(Entity entity, Long id) {
		super();
		this.entity = entity;
		this.id = id;
	}

	//TODO el mensaje esta atado a que no se encontro un insumo.MAL
	@Override
	public String getMessage() {
		return String.format(Errors.INSUMO_NOT_FOUND, entity, id);
	}
}
