package com.example.travelagency_backend.controller;

import com.example.travelagency_backend.dto.auth.AuthenticationRequest;
import com.example.travelagency_backend.dto.auth.AuthenticationResponse;
import com.example.travelagency_backend.dto.auth.RefreshTokenRequest;
import com.example.travelagency_backend.dto.auth.RegisterRequest;
import com.example.travelagency_backend.exception.RefreshTokenNotFoundException;
import com.example.travelagency_backend.exception.UserNotFoundException;
import com.example.travelagency_backend.service.auth.AuthenticationService;
import com.example.travelagency_backend.service.auth.JwtService;
import com.example.travelagency_backend.service.auth.RefreshTokenService;
import com.example.travelagency_backend.entity.auth.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest request) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/refresh")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) throws RefreshTokenNotFoundException {
        String refreshToken = refreshTokenRequest.getToken();
        return refreshTokenService.findByToken(refreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String accessToken = jwtService.generateToken(user);
                    return AuthenticationResponse
                            .builder()
                            .accessToken(accessToken)
                            .updateToken(refreshToken)
                            .build();
                }).orElseThrow(() -> new RefreshTokenNotFoundException("Refresh token not found"));
    }
}
