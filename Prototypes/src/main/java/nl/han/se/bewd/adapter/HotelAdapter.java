package nl.han.se.bewd.prototypetrenadapterpattern;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HotelAdapter implements IHotelService {

    @Override
    public void fetchHotels(double latitude, double longitude) {
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

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("API Response:");
            System.out.println(response.body());

            Hotel hotel = map(response.body());
            hotel.bookHotel();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Hotel map(String response) {
        Hotel hotel = new Hotel();
        hotel.setDestination("Booking.com hotel op locatie");
        return hotel;
    }
}