package br.com.heroes.Heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.heroes.Heroes.entities.HeroesEntity;

@Repository
public interface HeroesRepository extends JpaRepository<HeroesEntity, Integer> {

}
