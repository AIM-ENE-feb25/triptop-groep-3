package nl.han.se.bewd;

public interface ExternalServiceAdapter {
    void callService(String serviceId, String payload);
    Object mapResponseToDomainModel(String response);
}