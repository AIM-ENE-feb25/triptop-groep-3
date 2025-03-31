package nl.han.se.bewd;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Using AuthServiceAdapter ===");
        AuthService authService = new AuthService(new AuthServiceAdapter());
        authService.authenticateUser("user@example.com");
    }
}
