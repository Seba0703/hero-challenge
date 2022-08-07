package com.project.hero.application.adapter;

import com.project.hero.domain.entity.Hero;

public interface HeroCommandService {

    Hero save(Hero hero);

    Hero update(Hero hero);

    void delete(Integer id);
}
