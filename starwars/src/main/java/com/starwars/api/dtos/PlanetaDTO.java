package com.starwars.api.dtos;

public class PlanetaDTO {
	private String nome;
	private	String clima;
	private String terreno;
	private Long idPlaneta;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Long getIdPlaneta() {
		return idPlaneta;
	}
	public void setIdPlaneta(Long idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	
	
}
