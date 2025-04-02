package nl.han.se.bewd;

import nl.han.se.bewd.authentication.AuthRepository;
import nl.han.se.bewd.authentication.AuthService;
import nl.han.se.bewd.authentication.AuthServiceAdapter;
import nl.han.se.bewd.transport.TransportService;
import nl.han.se.bewd.transport.TransportServiceAdapter;

public class App {
    public static void main(String[] args) {

        iExternalServiceAdapter authAdapter = new AuthServiceAdapter();
        iExternalServiceAdapter transportAdapter = new TransportServiceAdapter();

        AuthService authService = new AuthService(authAdapter, new AuthRepository());
        TransportService transportService = new TransportService(transportAdapter);

        authService.authenticateUser("nietbestaand@email.com");
        authService.authenticateUser("bestaand@email.com");
    }
}
