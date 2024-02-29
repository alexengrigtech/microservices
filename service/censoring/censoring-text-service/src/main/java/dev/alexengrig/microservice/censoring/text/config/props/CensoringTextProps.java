package dev.alexengrig.microservice.censoring.text.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Data
@ConfigurationProperties("censoring.text")
public class CensoringTextProps {

    /**
     * Lower case words
     */
    private Set<String> blacklist;

}
