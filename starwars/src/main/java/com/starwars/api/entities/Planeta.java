package com.starwars.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planeta")
public class Planeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private	String nome;
	private	String clima;
	private String terreno;
	private int quantidadeFilmes;
	
	public Planeta() {
		
	}
	
	public Planeta(String nome, String clima, String terreno,int quantidadeFilmes) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeFilmes = quantidadeFilmes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	public int getQuantidadeFilmes() {
		return quantidadeFilmes;
	}

	public void setQuantidadeFilmes(int quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}
}
