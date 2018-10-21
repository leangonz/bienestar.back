package ungs.bienestar.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "reporte_categoria_mes_anio")
@Immutable
@IdClass(value = CategoriaMesAnioId.class)
public class CategoriaMesAnioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String categoria;
	
	@Id
	private Integer anio;
	
	private Double enero;
	
	private Double febrero;
	
	private Double marzo;
	
	private Double abril;
	
	private Double mayo;
	
	private Double junio;
	
	private Double julio;
	
	private Double agosto;
	
	private Double septiembre;
	
	private Double octubre;
	
	private Double noviembre;
	
	private Double diciembre;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getEnero() {
		return enero;
	}

	public void setEnero(Double enero) {
		this.enero = enero;
	}

	public Double getFebrero() {
		return febrero;
	}

	public void setFebrero(Double febrero) {
		this.febrero = febrero;
	}

	public Double getMarzo() {
		return marzo;
	}

	public void setMarzo(Double marzo) {
		this.marzo = marzo;
	}

	public Double getAbril() {
		return abril;
	}

	public void setAbril(Double abril) {
		this.abril = abril;
	}

	public Double getMayo() {
		return mayo;
	}

	public void setMayo(Double mayo) {
		this.mayo = mayo;
	}

	public Double getJunio() {
		return junio;
	}

	public void setJunio(Double junio) {
		this.junio = junio;
	}

	public Double getJulio() {
		return julio;
	}

	public void setJulio(Double julio) {
		this.julio = julio;
	}

	public Double getAgosto() {
		return agosto;
	}

	public void setAgosto(Double agosto) {
		this.agosto = agosto;
	}

	public Double getSeptiembre() {
		return septiembre;
	}

	public void setSeptiembre(Double septiembre) {
		this.septiembre = septiembre;
	}

	public Double getOctubre() {
		return octubre;
	}

	public void setOctubre(Double octubre) {
		this.octubre = octubre;
	}

	public Double getNoviembre() {
		return noviembre;
	}

	public void setNoviembre(Double noviembre) {
		this.noviembre = noviembre;
	}

	public Double getDiciembre() {
		return diciembre;
	}

	public void setDiciembre(Double diciembre) {
		this.diciembre = diciembre;
	}
	
}
