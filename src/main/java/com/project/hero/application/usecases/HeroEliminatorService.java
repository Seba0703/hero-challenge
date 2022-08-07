package com.project.hero.application.usecases;

import com.project.hero.application.adapter.HeroCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class HeroEliminatorService {

    @Autowired
    private HeroCommandService heroCommandService;

    @CacheEvict(value = "heroes", key = "#id")
    public void delete(Integer id) {
        heroCommandService.delete(id);
    }


}
