package nl.han.se.bewd.prototypetrenadapterpattern;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class HotelAdapter implements IHotelService {
    @Override
    public List<Map<String, Object>> fetchHotels(double latitude, double longitude, int amount) {
        try {
            String url = "https://booking-com.p.rapidapi.com/v1/hotels/search-by-coordinates?" +
                    "page_number=0&locale=en-gb&longitude=" + longitude +
                    "&checkout_date=2025-06-17&latitude=" + latitude +
                    "&room_number=1&include_adjacency=true&filter_by_currency=AED" +
                    "&checkin_date=2025-06-16&order_by=popularity&children_ages=5%2C0" +
                    "&categories_filter_ids=class%3A%3A2%2Cclass%3A%3A4%2Cfree_cancellation%3A%3A1" +
                    "&units=metric&children_number=2&adults_number=2";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", "f562c0686fmsh7e337efc7095d2dp1e7ebejsn6061c09d7317")
                    .header("x-rapidapi-host", "booking-com.p.rapidapi.com")
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject external = new JSONObject(response.body());
            JSONArray results = external.getJSONArray("result");

            List<Map<String, Object>> hotels = new ArrayList<>();

            for (int i = 0; i < Math.min(amount, results.length()); i++) {
                JSONObject hotel = results.getJSONObject(i);
                Map<String, Object> mapped = new HashMap<>();
                mapped.put("name", hotel.getString("hotel_name"));
                mapped.put("address", hotel.getString("address"));
                mapped.put("price", hotel.getJSONObject("price_breakdown").getDouble("gross_price"));
                mapped.put("rating", hotel.getDouble("review_score"));
                hotels.add(mapped);
            }

            return hotels;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
