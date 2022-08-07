package com.project.hero.application.usecases;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetHeroService {

    @Autowired
    private HeroCommandService heroCommandService;

    @Autowired
    private HeroMapper heroMapper;

    public HeroDTO save(HeroeRequest req) {
        var hero = heroMapper.toEntity(req);

        hero = heroCommandService.save(hero);

        return heroMapper.toDTO(hero);
    }
}
