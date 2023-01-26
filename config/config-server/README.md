# config-server

## env

Required:

- `CONFIG_SERVER_GIT_URL`

Optional:

- `CONFIG_SERVER_PORT=8888`
- `CONFIG_SERVER_GIT_USERNAME`
- `CONFIG_SERVER_GIT_PASSWORD`

### eureka

`EUREKA_DEFAULT_ZONE_URL` or `EUREKA_SERVER_URL`

## repository

```text
repository/
    application.yml
    application/
        application.yml
        application-profile.yml
        service1/
            application.yml
            application-profile1.yml
        service2/
            application.yml
            application-profile2.yml
    infrastructure/
        application.yml
        application-profile.yml
        service/
            application.yml
            application-profile.yml
```
