package com.smartdelivery.controller;

import org.springframework.web.bind.annotation.*;

import com.smartdelivery.dto.LoginRequest;
import com.smartdelivery.dto.SignupRequest;
import com.smartdelivery.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {

        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return authService.login(request);
    }
}