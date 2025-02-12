package com.example.springbootReviewMongoDB.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Reemplaza con tu dominio de aplicación
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
//                .allowCredentials(true);
//                .maxAge(3600);
    }

}
