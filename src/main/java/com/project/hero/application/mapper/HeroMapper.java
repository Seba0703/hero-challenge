package com.project.hero.application.mapper;

import com.project.hero.application.dto.HeroDTO;
import com.project.hero.domain.entity.Hero;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import com.project.hero.infrastructure.rest.response.HeroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    Hero toEntity(HeroeRequest req);

    Hero updateEntity(@MappingTarget Hero oldHero, HeroeRequest newHero);

    HeroDTO toDTO(Hero hero);

    HeroResponse toResponse(HeroDTO hero);
}
