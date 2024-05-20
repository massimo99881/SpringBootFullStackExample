package edu.quintainfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("*") // Specifica qui l'origine consentita per le richieste  http://127.0.0.1:5500
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*"); // Specifica gli header consentiti
    }
}
