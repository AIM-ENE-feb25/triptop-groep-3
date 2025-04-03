package nl.han.se.bewd.adapter;

import nl.han.se.bewd.response.AuthResponse;

public interface iAuthProviderAdapter {
    AuthResponse callService(String serviceId, String payload);
    Object mapResponseToDomainModel(String response, String serviceId);
}