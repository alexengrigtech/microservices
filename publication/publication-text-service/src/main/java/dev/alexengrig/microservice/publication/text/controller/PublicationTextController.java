package dev.alexengrig.microservice.publication.text.controller;

import dev.alexengrig.microservice.publication.text.service.PublicationTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internal/publications/texts")
public class PublicationTextController {

    private final PublicationTextService service;

    @PostMapping
    public UUID publish(@RequestBody String text) {
        return service.publish(text);
    }

}
