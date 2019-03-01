package com.starwars.api.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.starwars.api.dtos.PlanetaDTO;
import com.starwars.api.dtos.Planets;
import com.starwars.api.entities.Planeta;
import com.starwars.api.services.PlanetaService;

@RestController
@RequestMapping("api/starwars/")
public class PlanetaController {

	
	@Autowired
	private PlanetaService service;
	
	@PostMapping
	public Planeta adicionarPlaneta(@RequestBody PlanetaDTO dto) {
		RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://swapi.co/api/planets/"+dto.getIdPlaneta();
        ResponseEntity<Planets> res = rt.exchange(url, HttpMethod.GET, entity, Planets.class);
		int numeroFilmes = 0;
		if(res.getBody().getFilms()!=null) {
        numeroFilmes = res.getBody().getFilms().size();
		}
		return service.adicionarPlaneta(dto.getNome(), dto.getClima(), dto.getTerreno(),numeroFilmes);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPlaneta(@PathVariable("id") Long id) {
		service.removerPlaneta(id);
	}
	
	
	@GetMapping(value="id/{id}")
	public Optional<Planeta> listarPorId(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value="all")
	public List<Planeta> listarTodos() {
		return service.findAll();
	}
	
	@GetMapping(value="nome/{nome}")
	public List<Planeta> listarPorNome(@PathVariable("nome") String nome) {
		return service.findByNome(nome);
	}
	
	@GetMapping(value="apiPublica/id/{id}")
	public ResponseEntity<Planets> listarPlanetaAPIById(@PathVariable("id") Long id) {
		RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://swapi.co/api/planets/"+id;
        ResponseEntity<Planets> res = rt.exchange(url, HttpMethod.GET, entity, Planets.class);
        return res;
		
	}
	
	
}
