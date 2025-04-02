package nl.han.se.bewd.adapter;

public interface iExternalServiceAdapter {
    void callService(String serviceId, String payload);
    Object mapResponseToDomainModel(String response);
}