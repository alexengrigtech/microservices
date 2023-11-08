package dev.alexengrig.microservice.publication.text.controller;

import dev.alexengrig.microservice.publication.text.service.PublicationTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publications/texts")
public class PublicationTextController {

    private final PublicationTextService service;

    @PostMapping
    public ResponseEntity<?> publish(@RequestBody String text) {
        UUID textId = service.publish(text);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{textId}")
                .buildAndExpand(textId)
                .toUri();
        return ResponseEntity
                .created(location)
                .build();
    }

    @GetMapping(value = "/{textId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> get(@PathVariable UUID textId) {
        return service.get(textId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Text not found by id: " + textId));
    }

}
