package com.project.hero.controller.unit;

import com.project.hero.service.HeroeRequestBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeroCrudControllerTest {
    @Autowired
    private HeroeRequestBuilder heroebuilder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Given_AltaHeroe_When_ElUsuarioQuiereCargarUnHeroe_Then_HeroeCreado() {
        var req = heroebuilder.build();
    }
}
