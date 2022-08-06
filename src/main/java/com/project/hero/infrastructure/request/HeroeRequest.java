package com.project.hero.infrastructure.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroeRequest {
    private Integer id;
    private String name;
    private String power;
}
