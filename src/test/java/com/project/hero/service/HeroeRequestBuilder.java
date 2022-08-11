package com.project.hero.service;

import com.github.javafaker.Faker;
import com.project.hero.infrastructure.rest.request.HeroeRequest;
import org.springframework.stereotype.Service;

@Service
public class HeroeRequestBuilder {

    private final Faker faker = new Faker();

    public HeroeRequest build() {
        return HeroeRequest.builder()
                .name(faker.superhero().name())
                .power(faker.superhero().power())
                .build();

    }
}
