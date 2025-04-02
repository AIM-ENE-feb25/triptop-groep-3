package nl.han.se.bewd.adapter;

import nl.han.se.bewd.adapter.iExternalServiceAdapter;
import nl.han.se.bewd.response.AuthResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthServiceAdapter implements iExternalServiceAdapter {
    private static final String API_URL = "https://easy-authenticator.p.rapidapi.com/newAuthKey";
    private static final String RAPIDAPI_KEY = "70a86ded3fmsh28c7c8558de8c7ep16db07jsn0d0a4e3c2dfa";
    private static final String RAPIDAPI_HOST = "easy-authenticator.p.rapidapi.com";

    @Override
    public void callService(String serviceId, String payload) {
        try {
            // Maak de API URL met de gebruikersgegevens
            String email = payload;  // Hier wordt de email als payload verwacht
            String requestUrl = API_URL + "?account=" + email + "&issuer=example";

            // Open een HTTP-verbinding
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // Voeg de vereiste headers toe
            conn.setRequestProperty("X-RapidAPI-Key", RAPIDAPI_KEY);
            conn.setRequestProperty("X-RapidAPI-Host", RAPIDAPI_HOST);

            // Check de response code
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                // Lees de response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Verwerk de response
                System.out.println("API Response: " + response.toString());
            } else {
                System.out.println("Error: API call failed with response code " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AuthResponse mapResponseToDomainModel(String response) {
        JSONObject json = new JSONObject(response);
        String secretCode = json.getString("secretCode");
        return new AuthResponse(secretCode);
    }
}
