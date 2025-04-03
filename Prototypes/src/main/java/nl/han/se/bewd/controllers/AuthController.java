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
    public AuthResponse newAuthKey(@RequestParam String email) {
        System.out.println("Controller: Called newAuthKey");
        return authService.addNewUser(email);
    }

    @PostMapping("/verify")
    public AuthResponse verify(@RequestParam String secretCode, @RequestParam String token) {
        System.out.println("Controller: Called verify");
        return authService.validateSecret(secretCode, token);
    }
}