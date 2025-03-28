package nl.han.se.bewd;

public class App {
    public static void main(String[] args) {
        AuthServiceAdapter authAdapter = new AuthServiceAdapter();
        TransportServiceAdapter transportAdapter = new TransportServiceAdapter();

        DatabaseService databaseService = new DatabaseService();

        Backend backend = new Backend(authAdapter, databaseService);

        authAdapter.callService("Auth123", "user@example.com");


    }
}
