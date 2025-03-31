package nl.han.se.bewd;

public class AuthService {
    private final ExternalServiceAdapter adapter;

    public AuthService(ExternalServiceAdapter adapter) {
        this.adapter = adapter;
    }

    public void authenticateUser(String email) {
        adapter.callService("AUTH", email);
        System.out.println("Authenticatie verwerkt.");
    }
}
