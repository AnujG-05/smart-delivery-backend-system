package com.smartdelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/")
    public Map<String, String> home() {

        return Map.of(
                "application", "Smart Delivery Backend System",
                "status", "Running"
        );
    }

    @GetMapping("/api/health")
    public Map<String, String> health() {

        return Map.of(
                "status", "UP"
        );
    }
}