package com.project.hero.application.usecases;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.application.adapter.HeroQueryService;
import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.exceptions.HeroNotFound;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.domain.entity.Hero;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroUpdaterService {

    @Autowired
    private HeroCommandService heroCommandService;

    @Autowired
    private HeroQueryService heroQueryService;

    @Autowired
    private HeroMapper heroMapper;

    @CachePut(value = "heroes", key = "#heroReq.id")
    public HeroDTO update(HeroeRequest heroReq) throws HeroNotFound {
        Optional<Hero> oldHeroOpt = heroQueryService.findHero(heroReq.getId());

        Hero oldHero = oldHeroOpt.orElseThrow(HeroNotFound::new);

        var heroUpdated = heroMapper.updateEntity(oldHero, heroReq);

        heroUpdated = heroCommandService.update(heroUpdated);

        return heroMapper.toDTO(heroUpdated);

    }
}
