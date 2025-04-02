package nl.han.se.bewd;

public interface iExternalServiceAdapter {
    void callService(String serviceId, String payload);
    Object mapResponseToDomainModel(String response);
}