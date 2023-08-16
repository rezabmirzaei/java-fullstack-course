package no.noroff.accelerate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "HTTP Mehods", description = "Demo")
@RestController
public class HttpMethodMappingController {

    /*
     * The preferred way of doing this depends on your coding style, team
     * conventions, and how much control you want over your annotations. The first
     * two examples are more concise and directly related to GET requests, while the
     * third example provides more flexibility if you need to handle different HTTP
     * methods using the same method. In most cases, developers tend to prefer the
     * first two examples for their simplicity and readability.
     */

    @Operation(summary = "Get foo", description = "Get the foo resource")
    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("foo") // GET: localhost:8080/foo
    public ResponseEntity<String> foo() {
        return new ResponseEntity<>("Foo!", HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Malformed request")
    })
    @GetMapping("bar") // GET: localhost:8080/bar
    public ResponseEntity<String> bar() {
        return ResponseEntity.ok().body("Bar!");
    }

    @Deprecated
    @Operation(summary = "Old get baz", deprecated = true)
    @RequestMapping(method = RequestMethod.GET, path = "baz") // GET: localhost:8080/baz
    public ResponseEntity<String> baz() {
        return ResponseEntity.ok().body("Baz!");
    }

    @Operation(summary = "Create a new Foo", description = "Creates a new Foo entity")
    @ApiResponse(responseCode = "201", description = "Foo created successfully")
    @PostMapping("foo") // POST: localhost:8080/foo
    public ResponseEntity<String> createFoo() {
        return new ResponseEntity<>("Foo created!", HttpStatus.CREATED);
    }

}
