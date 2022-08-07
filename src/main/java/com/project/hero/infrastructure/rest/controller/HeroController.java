package com.project.hero.infrastructure.rest.controller;

import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.application.usecases.SaveHeroService;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import com.project.hero.infrastructure.rest.response.HeroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
public class HeroController {

    @Autowired
    private SaveHeroService heroService;

    @Autowired
    private HeroMapper heroMapper;

    @PostMapping(value = "/hero", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public HeroResponse createHero(@RequestBody HeroeRequest req) {
        HeroDTO hero = heroService.save(req);
        return heroMapper.toResponse(hero);
    }
}
