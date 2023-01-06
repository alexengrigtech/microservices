package dev.alexengrig.microservice.censoring.text.controller;

import dev.alexengrig.microservice.censoring.text.service.CensoringTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internal/censoring/texts")
public class CensoringTextController {

    private final CensoringTextService service;

    @PostMapping
    public void censor(@RequestBody String text) {
        service.censor(text);
    }

}
