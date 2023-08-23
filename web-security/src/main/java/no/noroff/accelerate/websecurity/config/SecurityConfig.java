package no.noroff.accelerate.websecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration  // Indicates this class provides configuration for the Spring application.
@EnableWebSecurity  // Enables Spring Security's web security features for the application.
@RequiredArgsConstructor  // Convenience - Lombok annotation to generate a constructor with required fields.
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    /*
     * @Bean marks the method as a Spring bean that will be managed by the Spring container.
     * Configure the security filter chain.
     * A series of filters that enforce security rules for incoming requests.
     */ 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        /*
         * Convenience for dev to quickly get an application up and running!
         * Compromises on important security aspects.
         * In a other environments, e.g. production set the proper policies for CORS and enable CSRF.
         */
        http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable());
        
        /*
         * Set stateless session creation policy, suitable for RESTful APIs.
         * Each request is treated independently without maintaining session state.
         */
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Configure request authorization rules.
        http
                .authorizeHttpRequests((authz) -> authz
                        // Allow unauthenticated access to the specified path.
                        .requestMatchers("/api/v1/resources/public").permitAll()
                        // Requires users to have the "ADMIN" role to access the specified path.
                        .requestMatchers("/api/v1/resources/admin").hasRole("ADMIN")
                        // Require authentication for any other request (maps to /api/v1/resources/restricted).
                        .anyRequest().authenticated())
                // Configure the OAuth2 resource server settings for handling JWT-based authentication.
                .oauth2ResourceServer((oauth2) -> oauth2
                        // Configure JWT-based authentication and sets a custom JWT authentication converter.
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthConverter)));
        
        /*
         * Build and return the configured `HttpSecurity` object.
         * Represents the security configuration for the application.
         */
        return http.build();
    }

}
