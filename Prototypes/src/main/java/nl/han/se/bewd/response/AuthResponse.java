package nl.han.se.bewd.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
    private String secretCode;
    private Boolean verify;

    public AuthResponse(String secretCode) {
        this.secretCode = secretCode;
        this.verify = null;
    }

    public AuthResponse(Boolean verify) {
        this.verify = verify;
        this.secretCode = null;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public Boolean getVerify() {
        return verify;
    }
}
