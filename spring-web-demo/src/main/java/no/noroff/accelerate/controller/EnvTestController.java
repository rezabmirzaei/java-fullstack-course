package no.noroff.accelerate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reading env. variables")
@RestController
@RequestMapping(path = "api/v1/test/env_var")
public class EnvTestController {

    Logger logger = LoggerFactory.getLogger(EnvTestController.class);

    @Value("${some.environment.variable}")
    private String someEnvVar;

    @GetMapping
    public ResponseEntity<String> envVar() {
        logger.warn("Oh no! Someone is trying to read my env. var!");
        return ResponseEntity.ok().body(String.format("Reading SOME_ENV_VAR: %s", someEnvVar));
    }
}
