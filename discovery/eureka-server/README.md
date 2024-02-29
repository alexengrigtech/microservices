# eureka-server

[Official docs](https://cloud.spring.io/spring-cloud-netflix/reference/html/#spring-cloud-eureka-server).

## env

Required:

- `EUREKA_SERVER_HOST`
- `EUREKA_DEFAULT_ZONE_URL` or `EUREKA_SERVER_URL` (`host:port`)

Optional:

- `EUREKA_SERVER_PORT=8761`
- `EUREKA_DEFAULT_ZONE_URL=${EUREKA_SERVER_URL}/eureka`
