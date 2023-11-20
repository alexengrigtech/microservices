ratingTextService = container "Rating-text-service" {
    tags "Text"
    technology "Spring Boot Application"
    -> configServer "Get config"
    -> discoveryServer "Get other services"
}
