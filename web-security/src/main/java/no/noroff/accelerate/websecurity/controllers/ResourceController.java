package no.noroff.accelerate.websecurity.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/resources")
public class ResourceController {

    @GetMapping("public")
    public ResponseEntity<String> publicEndpoint() {
        return new ResponseEntity<>(
                "A public endpoint, accessible anonymously.",
                HttpStatus.OK);
    }

    @GetMapping("restricted")
    public ResponseEntity<String> restrictedEndpoint() {
        return new ResponseEntity<>(
                "A restricted endpoint, accessible only when logged in.",
                HttpStatus.OK);
    }

    @GetMapping("admin")
    public ResponseEntity<String> adminEndpoint() {
        return new ResponseEntity<>(
                "Admin endpoint, accessible only for admins.",
                HttpStatus.OK);
    }

}
