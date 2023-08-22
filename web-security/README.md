## 1. Set up Keycloak
``docker run --name keycloak -dp 8083:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev``

1. Create realm ``noroff``
2. Create client ``spring-web-security``
3. Create 2 users
4. Create ADMIN role
5. Assign ADMIN role to one of the users only

## 2 Set up Spring Boot application

Heads up: current course content is deprecated, refer to [Spring doc. for migration](https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html).