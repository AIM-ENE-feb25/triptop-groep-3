package nl.han.se.bewd.authentication;

import java.util.HashSet;
import java.util.Set;

public class AuthRepository {
    private final Set<String> mockDatabase;

    public AuthRepository() {
        mockDatabase = new HashSet<>();
        mockDatabase.add("bestaand@email.com"); // Simuleer een bestaand e-mailadres
    }

    public String findEmail(String email) {
        if (mockDatabase.contains(email)) {
            return email;
        }
        return null; // E-mail niet gevonden
    }
}
