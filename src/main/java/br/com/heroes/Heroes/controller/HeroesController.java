package br.com.heroes.Heroes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heroes.Heroes.entities.HeroesEntity;
import br.com.heroes.Heroes.repository.HeroesRepository;

@RestController
@RequestMapping("/heroes")
public class HeroesController {

	@Autowired
	private HeroesRepository heroesRepository;

	@GetMapping
	public List< HeroesEntity > getAllHeroesEntities() {
		return heroesRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity< HeroesEntity > getHeroesEntitiesById(@PathVariable(value = "id") Integer heroesEntityId)
			throws ResourceNotFoundException {
		HeroesEntity heroesEntity = heroesRepository.findById(heroesEntityId)
				.orElseThrow(() -> new ResourceNotFoundException("Hero not found for this id ::" + heroesEntityId));

		return ResponseEntity.ok().body(heroesEntity);
	}
	

	
//	  @PostMapping("/") 
//	  public void save(@RequestBody HeroesEntity heroesEntity) { 
//		  heroesRepository.save(heroesEntity); 
//		  }
	 

	
	 @PostMapping
	 public HeroesEntity createHeroesEntity(@Validated @RequestBody HeroesEntity heroesEntity) {
	 return heroesRepository.save(heroesEntity); 
	 }
	 

	@PutMapping("/{id}")
	public ResponseEntity<HeroesEntity> updateHeroesEntity(@PathVariable(value = "id") Integer heroesEntityId,
			@Validated @RequestBody HeroesEntity heroesEntityDetails) throws ResourceNotFoundException {
		HeroesEntity heroesEntity = heroesRepository.findById(heroesEntityId)
				.orElseThrow(() -> new ResourceNotFoundException("Hero not found for this id::" + heroesEntityId));

		heroesEntity.setName(heroesEntityDetails.getName());
		final HeroesEntity updateHeroesEntity = heroesRepository.save(heroesEntity);
		return ResponseEntity.ok(updateHeroesEntity);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteHeroesEntity(@PathVariable(value = "id") Integer heroesEntityId)
			throws ResourceNotFoundException {
		HeroesEntity heroesEntity = heroesRepository.findById(heroesEntityId)
				.orElseThrow(() -> new ResourceNotFoundException("Hero not found for this id::" + heroesEntityId));

		heroesRepository.delete(heroesEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

}
