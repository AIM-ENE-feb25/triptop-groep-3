package nl.han.se.bewd.response;

public class AuthResponse {
    private String message;

    public AuthResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
