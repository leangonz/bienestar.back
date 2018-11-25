package ungs.bienestar.back.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungs.bienestar.back.dto.ProveedorDto;
import ungs.bienestar.back.entity.Proveedor;
import ungs.bienestar.back.exception.NotFoundException;
import ungs.bienestar.back.service.FormaDePagoService;
import ungs.bienestar.back.service.CiudadService;

@Component
public class ProveedorFactory {

	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private FormaDePagoService formaDePagoService;
	
	public Proveedor crearProveedor(ProveedorDto dto) throws NotFoundException {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombreProveedor(dto.getNombre());
		proveedor.setCuit(dto.getCuit());
		proveedor.setCiudad(ciudadService.obtenerCiudadBy(dto.getLocalidad()));
		proveedor.setCalle(dto.getCalle());
		proveedor.setAltura(dto.getAltura());
		proveedor.setFormaDePago(formaDePagoService.obtenerFormaDePagoBy(dto.getFormaDePago()));
		proveedor.setContacto(dto.getContacto());
		proveedor.setMail(dto.getMail());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setActivo(true);
		return proveedor;
	}

	public Proveedor actualizarProveedor(ProveedorDto origen, Proveedor destino) throws NotFoundException {
		destino.setCuit(origen.getCuit());
		destino.setCiudad(ciudadService.obtenerCiudadBy(origen.getLocalidad()));
		destino.setCalle(origen.getCalle());
		destino.setAltura(origen.getAltura());
		destino.setFormaDePago(formaDePagoService.obtenerFormaDePagoBy(origen.getFormaDePago()));
		destino.setContacto(origen.getContacto());
		destino.setMail(origen.getMail());
		destino.setTelefono(origen.getTelefono());
		return destino;
	}
}
