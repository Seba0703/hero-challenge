package com.project.hero.application.usecases;

import com.project.hero.application.adapter.HeroQueryService;
import com.project.hero.application.dto.HeroDTO;
import com.project.hero.application.exceptions.HeroNotFound;
import com.project.hero.application.mapper.HeroMapper;
import com.project.hero.domain.entity.Hero;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroFinderService {

    @Autowired
    private HeroQueryService heroQueryService;

    @Autowired
    private HeroMapper heroMapper;

    @Cacheable( value = "heroes")
    public HeroDTO findHero(Integer id) throws HeroNotFound {
        Optional<Hero> getHero = heroQueryService.findHero(id);

        return heroMapper.toDTO(getHero.orElseThrow(HeroNotFound::new));

    }

    public Page<HeroDTO> findAll(Pageable pageable, Specification<Hero> where) {

        Page<Hero> heroes = heroQueryService.findAllPaged(pageable, where);

        return  heroes.map(heroMapper::toDTO);
    }
}
