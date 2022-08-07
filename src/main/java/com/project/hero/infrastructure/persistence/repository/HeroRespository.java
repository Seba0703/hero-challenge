package com.project.hero.infrastructure.persistence.repository;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.application.adapter.HeroQueryService;
import com.project.hero.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRespository extends JpaRepository<Hero, Integer>, HeroCommandService, HeroQueryService {

    default Optional<Hero> findHero(Integer id) {
        return this.findById(id);
    }

}
