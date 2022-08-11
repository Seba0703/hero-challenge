package com.project.hero.application.usecases;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.application.adapter.HeroQueryService;
import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SaveHeroService {

    @Autowired
    private HeroCommandService heroCommandService;

    @Autowired
    private HeroMapper heroMapper;

    @Autowired
    private HeroQueryService heroQueryService;

    public HeroDTO save(HeroeRequest req) {
        var hero = heroMapper.toEntity(req);

        hero = heroCommandService.save(hero);
        return heroMapper.toDTO(hero);
    }
}
