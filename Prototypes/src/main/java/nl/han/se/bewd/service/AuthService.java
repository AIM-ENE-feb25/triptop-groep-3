package nl.han.se.bewd.service;

import nl.han.se.bewd.repository.AuthRepository;
import nl.han.se.bewd.adapter.iAuthProviderAdapter;
import nl.han.se.bewd.response.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final iAuthProviderAdapter authAdapter;
    private final AuthRepository authRepository;

    public AuthService(iAuthProviderAdapter authAdapter, AuthRepository authRepository) {
        this.authAdapter = authAdapter;
        this.authRepository = authRepository;
    }

    public AuthResponse addNewUser(String email) {
        return authAdapter.callService("NEW_AUTH_KEY", email);
    }


    public AuthResponse validateSecret(String secretCode, String token) {
        System.out.println("Validating secret...");

        // Maak de payload string voor de API call
        String payload = "secretCode=" + secretCode + "&token=" + token;

        // Roep direct de externe service aan en krijg een AuthResponse terug
        return authAdapter.callService("VERIFY", payload);
    }


}
