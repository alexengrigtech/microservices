censoringTextService = container "Censoring-text-service" {
    tags "Text"
    technology "Spring-boot"
    -> configServer "Get config"
    -> discoveryServer "Get other services"
}
