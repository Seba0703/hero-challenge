package com.project.hero.application.mapper;

import com.project.hero.application.dto.HeroDTO;
import com.project.hero.domain.entity.Hero;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import com.project.hero.infrastructure.rest.response.HeroResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    Hero toEntity(HeroeRequest req);

    HeroDTO toDTO(Hero hero);

    HeroResponse toResponse(HeroDTO hero);
}
