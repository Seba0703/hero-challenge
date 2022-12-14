package com.project.hero.application.adapter;

import com.project.hero.domain.entity.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface HeroQueryService {

    Optional<Hero> findHero(Integer id);

    Page<Hero> findAllPaged(Pageable pageable, Specification<Hero> where);
}
