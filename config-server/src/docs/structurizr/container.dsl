configServer = container "Configuration-server" {
    technology "Spring Cloud Config Server"
    -> discoveryServer "Register itself"
    -> configRepository "Get config"
}