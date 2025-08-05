package com.jonas.dropLearn.services;

import com.jonas.dropLearn.config.JwtService;
import com.jonas.dropLearn.dtos.AuthenticationRequest;
import com.jonas.dropLearn.dtos.AuthenticationResponse;
import com.jonas.dropLearn.dtos.RegisterRequest;
import com.jonas.dropLearn.enums.Role;
import com.jonas.dropLearn.models.User;
import com.jonas.dropLearn.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role() != null ? request.role() : Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user.getEmail());
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        var jwtToken = jwtService.generateToken(request.email());
        return new AuthenticationResponse(jwtToken);
    }
}
