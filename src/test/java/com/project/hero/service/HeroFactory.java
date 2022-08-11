package com.project.hero.service;

import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.usecases.SaveHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroFactory {
    @Autowired
    private SaveHeroService saveHeroService;
    @Autowired
    private HeroeRequestBuilder heroeRequestBuilder;

    public HeroDTO create() {
        var req = heroeRequestBuilder.build();
        return saveHeroService.save(req);
    }
}
