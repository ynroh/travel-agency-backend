package com.example.travelagency_backend.service.auth;

import com.example.travelagency_backend.dto.auth.AuthenticationRequest;
import com.example.travelagency_backend.dto.auth.AuthenticationResponse;
import com.example.travelagency_backend.dto.auth.RegisterRequest;
import com.example.travelagency_backend.entity.UserEntity;
import com.example.travelagency_backend.entity.auth.RefreshToken;
import com.example.travelagency_backend.exception.EmailIsOccupiedException;
import com.example.travelagency_backend.exception.PhoneNumberIsOccupiedException;
import com.example.travelagency_backend.exception.UserNotFoundException;
import com.example.travelagency_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final String apiUrl = "https://localhost:8080";

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;
    private final String basicAvatarUrl = System.getProperty("user.dir") + "/uploads" + "/users";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    public AuthenticationResponse register(RegisterRequest request) throws PhoneNumberIsOccupiedException, EmailIsOccupiedException {
        validateRegisterRequest(request);

        var user = UserEntity.builder()
                .phone_number(request.getPhone_number())
                .email(request.getEmail())
                .login(request.getPhone_number())
                .photo_url(basicAvatarUrl + "photo.jpeg")
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        repository.save(user);

        String jwtToken = jwtService.generateToken(user);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getLogin());

        return AuthenticationResponse
                .builder()
                .accessToken(jwtToken)
                .updateToken(refreshToken.getToken())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UserNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        var user = repository.findByLogin(request.getLogin()).orElseThrow(() -> new UserNotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(user);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getLogin());

        return AuthenticationResponse
                .builder()
                .accessToken(jwtToken)
                .updateToken(refreshToken.getToken())
                .build();
    }

    private void validateRegisterRequest(RegisterRequest request) throws EmailIsOccupiedException, PhoneNumberIsOccupiedException {
        if (repository.findByEmail(request.getEmail()).isPresent())
            throw new EmailIsOccupiedException("Account with this email is already registered");
        if (repository.findByLogin(request.getPhone_number()).isPresent())
            throw new PhoneNumberIsOccupiedException("Account with this phone number is already registered");
    }
}
