package com.starwars.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.entities.Planeta;
import com.starwars.api.repository.PlanetaRepository;
import com.starwars.api.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService{

	@Autowired
	private PlanetaRepository repositorio;
	
	@Override
	public Optional<Planeta> findById(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Planeta> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<Planeta> findByNome(String nome) {
		return repositorio.findByNome(nome);
	}

	@Override
	public Planeta adicionarPlaneta(String nome, String clima, String terreno,int quantidadeFilmes) {
		Planeta p = new Planeta(nome, clima, terreno,quantidadeFilmes);
		return repositorio.save(p);
	}

	@Override
	public void removerPlaneta(Long id) {
		this.repositorio.delete(id);
		
	}
	

}
