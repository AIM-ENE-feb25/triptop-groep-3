package nl.han.se.bewd.response;

public class AuthResponse {
    private boolean valid;
    private String message;

    public AuthResponse() {}

    public AuthResponse(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public AuthResponse(String message) {
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}