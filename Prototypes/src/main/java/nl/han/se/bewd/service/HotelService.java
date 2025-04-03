package nl.han.se.bewd.service;



import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.client.BookingApiClient;

import java.util.List;
import java.util.Map;

public class HotelService {
    private final BookingApiClient bookingClient;

    public HotelService() {
        this.bookingClient = new BookingApiClient(new ExternalApiHotelAdapter());
    }

    public List<Map<String, Object>> getHotels(double latitude, double longitude, int amount) {
        return bookingClient.useHotelService(latitude, longitude, amount);
    }
}


