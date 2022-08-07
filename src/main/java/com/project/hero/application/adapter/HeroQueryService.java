package com.project.hero.application.adapter;

import com.project.hero.domain.entity.Hero;

import java.util.Optional;

public interface HeroQueryService {

    Optional<Hero> findHero(Integer id);
}
