package dev.alexengrig.microservice.publication.text.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "dev.alexengrig.microservice.publication.text.client")
public class FeignClientConfig {
}
