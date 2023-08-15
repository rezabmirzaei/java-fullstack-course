package com.example.demo10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/test") // Base URL
public class BaseURLAndRequestController {

    // Extracting path variable
    @GetMapping("{id}") // GET: localhost:8080/api/v1/test/1
    public ResponseEntity<String> path(@PathVariable int id) {
        return ResponseEntity.ok().body(String.valueOf(id));
    }

    // Extracting a query string
    @GetMapping // GET: localhost:8080/api/v1/test?key=value
    public ResponseEntity<String> query(@RequestParam String key) {
        return ResponseEntity.ok().body(key);
    }

    // Extracts the User-Agent header
    @GetMapping("header") // GET: localhost:8080/api/v1/header
    public ResponseEntity<String> headers(@RequestHeader("User-Agent") String agent) {
        return ResponseEntity.ok().body(agent);
    }

    // Extracts the body
    @GetMapping("body") // GET: localhost:8080/api/v1/body
    public ResponseEntity<String> body(@RequestBody String value) {
        return ResponseEntity.ok().body(value);
    }
}
