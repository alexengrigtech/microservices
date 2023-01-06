package dev.alexengrig.microservice.censoring.text.config;

import dev.alexengrig.microservice.censoring.text.config.props.CensoringTextProps;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CensoringTextProps.class)
public class CensoringTextConfig {
}
