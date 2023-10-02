package dev.alexengrig.microservice.censoring.text.config.props;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Getter
@AllArgsConstructor
@ConfigurationProperties("censoring.text")
public class CensoringTextProps {

    /**
     * Lower case words
     */
    private Set<String> blacklist;

}
