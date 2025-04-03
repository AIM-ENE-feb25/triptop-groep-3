package nl.han.se.bewd.controllers;

import nl.han.se.bewd.response.AuthResponse;
import nl.han.se.bewd.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/newAuthKey")
    public AuthResponse verifyUser(@RequestParam String email) {
        System.out.println("Called verifyUser");
        return authService.authenticateUser(email);
    }

    @PostMapping("/verify")
    public AuthResponse validateToken(@RequestParam String secretCode, @RequestParam String token) {
        System.out.println("Called validateToken");
        return authService.validateSecret(secretCode, token);
    }
}