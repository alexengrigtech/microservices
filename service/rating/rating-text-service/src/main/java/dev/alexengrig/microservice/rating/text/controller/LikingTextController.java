package dev.alexengrig.microservice.rating.text.controller;

import dev.alexengrig.microservice.rating.text.service.LikingTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ratings/texts/likings")
public class LikingTextController {

    private final LikingTextService service;

    @PostMapping("/{textId}")
    public void like(@PathVariable UUID textId) {
        service.like(textId);
    }

}
