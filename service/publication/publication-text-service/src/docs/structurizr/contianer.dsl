publicationTextService = container "Publication-text-service" {
    tags "Text"
    technology "Spring-boot"
    -> configServer "Get config"
    -> discoveryServer "Get other services"
    -> censoringTextService "Check text on censor"
}
