package com.starwars.api.services;

import java.util.List;
import java.util.Optional;

import com.starwars.api.entities.Planeta;

public interface PlanetaService {

	
	/**
	 * Retorna um planeta por id
	 * @param id
	 * @return Optional<Planeta>
	 */
	Optional<Planeta> findById(Long id);
	/**
	 * Lista todos os planetas cadastrados
	 * @return List<Planeta>
	 */
	
	List<Planeta> findAll();
	
	/**
	 * Lista os planetas por nome
	 * @param nome
	 * @return List<Planeta>
	 */
	List<Planeta> findByNome(String nome);
	
	/**
	 * Adiciona um novo planeta
	 * @param nome
	 * @param clima
	 * @param terreno
	 * @return Planeta
	 */
	Planeta adicionarPlaneta(String nome,String clima,String terreno,int quantidadeFilmes);
	
	/**
	 * remove o planeta 
	 * @param id
	 */
	void removerPlaneta(Long id);
	
}
