package nl.han.se.bewd;

public class Backend {
    private ExternalServiceAdapter externalService;
    private DatabaseService databaseService;

    public Backend(ExternalServiceAdapter externalService, DatabaseService databaseService) {
        this.externalService = externalService;
        this.databaseService = databaseService;
    }

    public void getAvailableServices() {
        System.out.println("Getting available services from database...");
    }

    public void processServiceRequest(String serviceId, String userId) {
        System.out.println("Processing service request for user " + userId);
        externalService.callService(serviceId, "payload");
    }

    public void authenticateUser(String token) {
        System.out.println("Authenticating user with token: " + token);
    }
}