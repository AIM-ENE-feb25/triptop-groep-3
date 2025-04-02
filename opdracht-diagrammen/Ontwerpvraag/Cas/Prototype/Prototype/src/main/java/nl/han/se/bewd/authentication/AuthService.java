package nl.han.se.bewd.authentication;

import nl.han.se.bewd.iExternalServiceAdapter;

public class AuthService {
    private final iExternalServiceAdapter authAdapter;
    private final AuthRepository authRepository;

    public AuthService(iExternalServiceAdapter authAdapter, AuthRepository authRepository) {
        this.authAdapter = authAdapter;
        this.authRepository = authRepository;
    }

    public void authenticateUser(String email) {
        System.out.println("Checking if email is registered in database...");

        String foundEmail = authRepository.findEmail(email);
        if (foundEmail != null) {
            System.out.println("✅ User found: " + foundEmail);
            authAdapter.callService("AUTH", email);
        } else {
            System.out.println("❌ Error: User not found!\n");
        }
    }
}
