package com.example.netflix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(TitleRepository titleRepository, ActorRepository actorRepository,
                                   DirectorRepository directorRepository, CategoryRepository categoryRepository) {

        return args -> {
        };
    }

}

