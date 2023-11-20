workspace "Workspace of microservices" "Workspace with microservices" {
    !identifiers hierarchical

    model {
        softwareSystem = softwareSystem "Microservices" "All microservices." {
            group "Discovery" {
                !include discovery/eureka-server/src/docs/structurizr/container.dsl
            }

            group "Configuration" {
                configRepository = container "Configuration repository" {
                    technology "Git"
                }

                !include config-server/src/docs/structurizr/container.dsl
            }

            group "Services" {
                !include service/censoring/censoring-text-service/src/docs/structurizr/container.dsl
                !include service/publication/publication-text-service/src/docs/structurizr/contianer.dsl
                !include service/rating/rating-text-service/src/docs/structurizr/container.dsl
            }
        }

        user = person "User" "A user of microservices." {
            -> softwareSystem "Uses"
        }
    }
}