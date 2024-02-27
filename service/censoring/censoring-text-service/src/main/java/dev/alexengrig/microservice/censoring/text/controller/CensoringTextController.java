package dev.alexengrig.microservice.censoring.text.controller;

import dev.alexengrig.microservice.censoring.text.service.CensoringTextException;
import dev.alexengrig.microservice.censoring.text.service.CensoringTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/censoring/texts")
public class CensoringTextController {

    private final CensoringTextService service;

    @PostMapping
    public ResponseEntity<?> censor(@RequestBody String text) {
        try {
            service.censor(text);
            return ResponseEntity.ok().build();
        } catch (CensoringTextException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
