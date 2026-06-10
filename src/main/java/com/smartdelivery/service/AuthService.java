package com.smartdelivery.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartdelivery.dto.LoginRequest;
import com.smartdelivery.dto.SignupRequest;
import com.smartdelivery.exception.UserNotFoundException;
import com.smartdelivery.model.User;
import com.smartdelivery.model.Role;
import com.smartdelivery.repository.UserRepository;
import com.smartdelivery.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepo,
                       JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupRequest request) {

    User user = new User();

    user.setName(request.getName());
    user.setEmail(request.getEmail());

    user.setPassword(
            encoder.encode(request.getPassword())
    );

    user.setRole(
            Role.valueOf(
                    request.getRole().toUpperCase()
            )
    );

    userRepo.save(user);

    return "Signup Successful";
}

    public String login(LoginRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
               .orElseThrow(() ->
        new UserNotFoundException("User not found"));

        if (encoder.matches(
                request.getPassword(),
                user.getPassword())) {
           return jwtUtil.generateToken(
        user.getEmail(),
        user.getRole().name()
);
        }

        return "Invalid Password";
    }
}
