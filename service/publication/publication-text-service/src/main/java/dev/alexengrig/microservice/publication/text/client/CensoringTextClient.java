package dev.alexengrig.microservice.publication.text.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "censoring-text-service", path = "/api/censoring/texts")
public interface CensoringTextClient {

    @PostMapping
    ResponseEntity<String> censor(@RequestBody String text);

}
