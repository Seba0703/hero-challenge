package com.project.hero.infrastructure.persistence.repository;

import com.project.hero.application.adapter.HeroCommandService;
import com.project.hero.application.adapter.HeroQueryService;
import com.project.hero.domain.entity.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRespository extends JpaRepository<Hero, Integer>,
        JpaSpecificationExecutor<Hero>,
        HeroCommandService,
        HeroQueryService {

    default Optional<Hero> findHero(Integer id) {
        return this.findById(id);
    }

    default Page<Hero> findAllPaged(Pageable pageable, Specification<Hero> where) {
        return this.findAll(where, pageable);
    }

    List<Hero> findByName(String name);

    default Hero update(Hero hero) {
        return ((CrudRepository<Hero, Integer>) this).save(hero);
    }

    default void delete(Integer id) {
        this.deleteById(id);
    }


}
