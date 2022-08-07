package com.project.hero.infrastructure.persistence.repository;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRespository extends JpaRepository<Hero, Integer>, HeroCommandService {
}
