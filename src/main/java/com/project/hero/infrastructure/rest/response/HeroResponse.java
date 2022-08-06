package com.project.hero.infrastructure.rest.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroResponse {
    private Integer id;
    private String name;
    private String power;
}
