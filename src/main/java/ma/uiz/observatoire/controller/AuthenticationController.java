package ma.uiz.observatoire.controller;

import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.auth.AuthenticationRequest;
import ma.uiz.observatoire.auth.AuthenticationResponse;
import ma.uiz.observatoire.auth.RegisterRequest;
import ma.uiz.observatoire.dto.AccountDTO;
import ma.uiz.observatoire.model.Account;
import ma.uiz.observatoire.model.Token;
import ma.uiz.observatoire.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/user")
    public ResponseEntity<AccountDTO> displayCurrentAccount(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.currentUser(token));
    }
}

