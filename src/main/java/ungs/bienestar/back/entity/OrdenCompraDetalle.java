package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden_compra_detalle")
public class OrdenCompraDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinea;
	
	@ManyToOne
    @JoinColumn(name="id_oc")
	private OrdenCompraHeader header;
	
	@ManyToOne
    @JoinColumn(name="id_movimiento")
	private Movimiento movimiento;
	
	@ManyToOne
    @JoinColumn(name="id_insumo")
	private Insumo insumo;
	
	@ManyToOne
    @JoinColumn(name="id_categoria_compra")
	private CategoriaCompra categoriaCompra;
	
	private String insumoOtro;
	
	private Double cantidad;
	
	private Double precioUnitario;

	public Long getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}

	public OrdenCompraHeader getHeader() {
		return header;
	}

	public void setHeader(OrdenCompraHeader header) {
		this.header = header;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public CategoriaCompra getCategoriaCompra() {
		return categoriaCompra;
	}

	public void setCategoriaCompra(CategoriaCompra categoriaCompra) {
		this.categoriaCompra = categoriaCompra;
	}

	public String getInsumoOtro() {
		return insumoOtro;
	}

	public void setInsumoOtro(String insumoOtro) {
		this.insumoOtro = insumoOtro;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
