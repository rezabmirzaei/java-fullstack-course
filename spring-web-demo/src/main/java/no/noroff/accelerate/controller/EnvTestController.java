package no.noroff.accelerate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/test/env_var")
public class EnvTestController {

    @Value("${some.environment.variable}")
    private String someEnvVar;

    @GetMapping
    public ResponseEntity<String> envVar() {
        return ResponseEntity.ok().body(someEnvVar);
    }
}
