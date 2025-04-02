package nl.han.se.bewd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApp {
    public static void main(String[] args) {
        SpringApplication.run(PrototypeApp.class, args);
//        iExternalServiceAdapter authAdapter = new AuthServiceAdapter();
//        iExternalServiceAdapter transportAdapter = new TransportServiceAdapter();
//
//        AuthService authService = new AuthService(authAdapter, new AuthRepository());
//        TransportService transportService = new TransportService(transportAdapter);
    }
}
