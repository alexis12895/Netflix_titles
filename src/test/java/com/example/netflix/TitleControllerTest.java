package com.example.netflix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TitleControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void all() {
        webTestClient.get()
                .uri("/title")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/hal+json");
    }


    @Test
    void one() {
        webTestClient.get()
                .uri("/title/1")
                .exchange()
                .expectBody()
                .jsonPath("$.name")
                .isEqualTo("Dick Johnson Is Dead");
    }

    //Me generara un error debido a que hay campues que no pueden ser nulos, por las validaciones
    @Test
    void createTitle() {

        Title title = new Title();
        webTestClient.post()
                .uri("/title")
                .bodyValue(title)
                .exchange()
                .expectStatus()
                .is5xxServerError();


    }

    //Debido a las referencias de las tablas, no se podra borrar un titulo sin borrar el resto de tablas
    @Test
    void deleteTitle() {
        webTestClient.delete()
                .uri("/title/50")
                .exchange()
                .expectStatus().isEqualTo(409);
    }

    @Test
    void titleNotFound(){
        webTestClient.get()
                .uri("/title/8978")
                .exchange()
                .expectStatus().isNotFound();
    }
}