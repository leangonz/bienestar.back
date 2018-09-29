package ungs.bienestar.back.dto;

import java.util.Date;
import java.util.List;

public class ConsumoRealizadoDto {

	private Date fecha;
	private Integer lactarios;
	private Integer unAnio;
	private Integer dosAnios;
	private Integer tresAnios;
	private Integer cuatroCincoAnios;
	private Integer adultos;
	private List<InsumoDto> insumos;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getLactarios() {
		return lactarios;
	}
	public void setLactarios(Integer lactarios) {
		this.lactarios = lactarios;
	}
	public Integer getUnAnio() {
		return unAnio;
	}
	public void setUnAnio(Integer unAnio) {
		this.unAnio = unAnio;
	}
	public Integer getDosAnios() {
		return dosAnios;
	}
	public void setDosAnios(Integer dosAnios) {
		this.dosAnios = dosAnios;
	}
	public Integer getTresAnios() {
		return tresAnios;
	}
	public void setTresAnios(Integer tresAnios) {
		this.tresAnios = tresAnios;
	}
	public Integer getCuatroCincoAnios() {
		return cuatroCincoAnios;
	}
	public void setCuatroCincoAnios(Integer cuatroCincoAnios) {
		this.cuatroCincoAnios = cuatroCincoAnios;
	}
	public Integer getAdultos() {
		return adultos;
	}
	public void setAdultos(Integer adultos) {
		this.adultos = adultos;
	}
	public List<InsumoDto> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<InsumoDto> insumos) {
		this.insumos = insumos;
	}
}
