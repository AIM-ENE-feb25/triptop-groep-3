package nl.han.se.bewd.adapter;

import nl.han.se.bewd.iExternalServiceAdapter;

public class TransportServiceAdapter implements iExternalServiceAdapter {
    @Override
    public void callService(String serviceId, String payload) {
        System.out.println("Calling Transport Service with ID: " + serviceId);
    }

    @Override
    public Object mapResponseToDomainModel(String response) {
        return "Mapped Transport Response: " + response;
    }
}
