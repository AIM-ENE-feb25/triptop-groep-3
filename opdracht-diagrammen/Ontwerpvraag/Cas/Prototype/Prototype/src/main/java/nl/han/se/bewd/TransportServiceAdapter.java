package nl.han.se.bewd;

public class TransportServiceAdapter implements ExternalServiceAdapter {
    @Override
    public void callService(String serviceId, String payload) {
        System.out.println("Calling Transport Service with ID: " + serviceId);
    }

    @Override
    public Object mapResponseToDomainModel(String response) {
        return "Mapped Transport Response: " + response;
    }
}
