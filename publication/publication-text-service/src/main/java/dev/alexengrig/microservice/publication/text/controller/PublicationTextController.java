package dev.alexengrig.microservice.publication.text.controller;

import dev.alexengrig.microservice.publication.text.service.PublicationTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internal/publications/texts")
public class PublicationTextController {

    private final PublicationTextService service;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody String text) {
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(service.publish(text).toString());
    }

}
