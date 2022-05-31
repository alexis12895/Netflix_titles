package com.example.netflix;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class TitleController {

    private final TitleRepository repository;

    TitleController(TitleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/recommend/best")
    List<Title> best(@RequestParam(name="top", required=true, defaultValue="10") Integer top) {
        return repository.findBest(top)
                .stream()
                .collect(Collectors.toList());
    }

}
