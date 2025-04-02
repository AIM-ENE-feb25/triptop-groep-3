package nl.han.se.bewd.service;

import nl.han.se.bewd.repository.AuthRepository;
import nl.han.se.bewd.adapter.iExternalServiceAdapter;
import nl.han.se.bewd.response.AuthResponse;

public class AuthService {
    private final iExternalServiceAdapter authAdapter;
    private final AuthRepository authRepository;

    public AuthService(iExternalServiceAdapter authAdapter, AuthRepository authRepository) {
        this.authAdapter = authAdapter;
        this.authRepository = authRepository;
    }

    public AuthResponse authenticateUser(String email) {
        System.out.println("Checking if email is registered in database...");

        String foundEmail = authRepository.findEmail(email);
        if (foundEmail != null) {
            System.out.println("✅ User found: " + foundEmail);
            authAdapter.callService("AUTH", email);
            return new AuthResponse("Geldige gebruiker: " + foundEmail);
        } else {
            System.out.println("❌ Error: User not found!\n");
            return new AuthResponse("Ongeldige gebruiker!");
        }
    }
}
