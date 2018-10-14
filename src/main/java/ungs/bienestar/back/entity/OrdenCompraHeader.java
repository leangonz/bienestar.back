package ungs.bienestar.back.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orden_compra_header")
public class OrdenCompraHeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOc;
	
	private Date fecha;
	
	private String factura;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_area")
	private Area area;
	
	@OneToMany(mappedBy = "header", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrdenCompraDetalle> detalle;

	private Double total;
	
	public Long getIdOc() {
		return idOc;
	}

	public void setIdOc(Long idOc) {
		this.idOc = idOc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<OrdenCompraDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<OrdenCompraDetalle> detalle) {
		this.detalle = detalle;
	}
	
	public void addCompraItem(OrdenCompraDetalle item) {
		this.detalle.add(item);
		item.setHeader(this);
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
