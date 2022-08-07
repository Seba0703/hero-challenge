package com.project.hero.infrastructure.rest.controller;

import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.exceptions.HeroNotFound;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.application.usecases.HeroEliminatorService;
import com.project.hero.application.usecases.HeroFinderService;
import com.project.hero.application.usecases.HeroUpdaterService;
import com.project.hero.application.usecases.SaveHeroService;
import com.project.hero.domain.entity.Hero;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import com.project.hero.infrastructure.rest.response.HeroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/hero")
public class HeroController {

    @Autowired
    private SaveHeroService saveHeroService;

    @Autowired
    private HeroFinderService heroFinderService;

    @Autowired
    private HeroUpdaterService heroUpdaterService;

    @Autowired
    private HeroEliminatorService heroEliminatorService;


    @Autowired
    private HeroMapper heroMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public HeroResponse createHero(@RequestBody HeroeRequest req) {
        HeroDTO hero = saveHeroService.save(req);
        return heroMapper.toResponse(hero);
    }

    @GetMapping("/{id}")
    public HeroResponse findHero(@PathVariable Integer id) throws HeroNotFound {

        HeroDTO hero = heroFinderService.findHero(id);

        return heroMapper.toResponse(hero);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public HeroResponse findHero(@RequestBody HeroeRequest req) throws HeroNotFound {

        HeroDTO hero = heroUpdaterService.update(req);

        return heroMapper.toResponse(hero);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteHero(@PathVariable Integer id) throws HeroNotFound {

        heroEliminatorService.delete(id);

    }

    @GetMapping
    public HeroResponse findAllHero() throws HeroNotFound {


        return null;
    }



}
