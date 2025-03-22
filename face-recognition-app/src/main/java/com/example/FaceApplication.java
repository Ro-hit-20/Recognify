package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Face Recognition application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class FaceApplication {
    
    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(FaceApplication.class, args);
    }
}