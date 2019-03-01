package com.starwars.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.api.entities.Planeta;
import java.lang.String;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

	Optional<Planeta> findById(Long id);
	List<Planeta> findAll();
	List<Planeta> findByNome(String nome);
}
