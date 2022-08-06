package com.project.hero.infrastructure.rest;

import com.project.hero.infrastructure.request.HeroeRequest;
import com.project.hero.infrastructure.response.HeroResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
public class HeroController {

    @PostMapping(value = "/hero", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void createHero(@RequestBody HeroeRequest req) {
    }
}
