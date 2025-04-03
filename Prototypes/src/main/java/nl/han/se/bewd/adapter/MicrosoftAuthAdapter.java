package nl.han.se.bewd.adapter;

import nl.han.se.bewd.response.AuthResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class MicrosoftAuthAdapter implements iAuthProviderAdapter {
    private static final String API_URL = "https://easy-authenticator.p.rapidapi.com/";
    private static final String RAPIDAPI_KEY = "70a86ded3fmsh28c7c8558de8c7ep16db07jsn0d0a4e3c2dfa";
    private static final String RAPIDAPI_HOST = "easy-authenticator.p.rapidapi.com";

    @Override
    public AuthResponse callService(String serviceId, String payload) {
        try {
            String requestUrl;

            switch (serviceId) {
                case "NEW_AUTH_KEY":
                    requestUrl = API_URL + "newAuthKey?" + payload;
                    break;
                case "VERIFY":
                    requestUrl = API_URL + "verify?" + payload;
                    break;
                default:
                    throw new IllegalArgumentException("Ongeldig serviceId: " + serviceId);
            }

            // Open een HTTP-verbinding
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // Voeg de vereiste headers toe
            conn.setRequestProperty("X-RapidAPI-Key", RAPIDAPI_KEY);
            conn.setRequestProperty("X-RapidAPI-Host", RAPIDAPI_HOST);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Check de response code
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("API response: " + response);

                return mapResponseToDomainModel(response.toString(), serviceId);
            } else {
                System.out.println("Error: API call failed with response code " + responseCode + "\n");
                return new AuthResponse("Error: API call failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AuthResponse("Error: Exception occurred.");
        }
    }


    @Override
    public AuthResponse mapResponseToDomainModel(String response, String serviceId) {
        JSONObject json = new JSONObject(response);

        switch (serviceId) {
            case "NEW_AUTH_KEY":
                return new AuthResponse(json.getString("secretCode"));
            case "VERIFY":
                return new AuthResponse(json.getBoolean("verify"));
            default:
                return new AuthResponse("Ongeldig serviceId: " + serviceId);
        }
    }


}
