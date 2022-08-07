package com.project.hero.controller.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hero.infrastructure.persistence.repository.HeroRespository;
import com.project.hero.service.HeroFactory;
import com.project.hero.service.HeroeRequestBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeroCrudControllerTest {
    @Autowired
    private HeroeRequestBuilder heroeReqBuilder;

    @Autowired
    private HeroFactory heroFactory;

    @Autowired
    private HeroRespository heroRepo;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String heroPath = "/v1/hero";

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void Given_AltaHeroe_When_ElUsuarioQuiereCargarUnHeroe_Then_HeroeCreado() throws Exception {
        var req = heroeReqBuilder.build();
        this.mockMvc.perform(
                post(heroPath)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req))
        )
                .andDo(print())
                .andExpect(
                        matchAll(
                                status().isOk(),
                                jsonPath("$.id", equalTo(req.getId())),
                                jsonPath("$.name", equalTo(req.getName())),
                                jsonPath("$.power", equalTo(req.getPower()))
                        )
                );

        assertTrue(heroRepo.findById(req.getId()).isPresent());

    }

    @Test
    public void Given_UnHeroeCreado_When_SeBuscaPorId_Then_unHeroeEsEncontrado() throws Exception {
        var hero = heroFactory.create();
        var heroFindId = heroPath.concat("/")
                .concat(String.valueOf(hero.getId()));

        this.mockMvc.perform(
                get(heroFindId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(
                        matchAll(
                                status().isOk(),
                                jsonPath("$.id", equalTo(hero.getId())),
                                jsonPath("$.name", equalTo(hero.getName())),
                                jsonPath("$.power", equalTo(hero.getPower()))

                        )
                );

    }
}
