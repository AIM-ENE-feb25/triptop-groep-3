package nl.han.se.bewd.controllers;

import nl.han.se.bewd.response.AuthResponse;
import nl.han.se.bewd.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/verify")
    public AuthResponse verifyUser(@RequestParam String email) {
        return authService.authenticateUser(email);
    }
}