package nl.han.se.bewd.adapter;

import nl.han.se.bewd.response.AuthResponse;

public class GoogleAuthAdapter implements iAuthProviderAdapter {
    @Override
    public AuthResponse callService(String serviceId, String payload) {
        System.out.println("Calling Transport Service with ID: " + serviceId);
        return null;
    }

    @Override
    public Object mapResponseToDomainModel(String response, String serviceId) {
        return null;
    }

}
