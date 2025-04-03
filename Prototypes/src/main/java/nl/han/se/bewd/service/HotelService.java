package nl.han.se.bewd.service;



import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.client.BookingAPIClient;

import java.util.List;
import java.util.Map;

public class HotelService {
    private final BookingAPIClient bookingClient;

    public HotelService() {
        this.bookingClient = new BookingAPIClient(new ExternalApiHotelAdapter());
    }

    public List<Map<String, Object>> getHotels(double latitude, double longitude, int amount) {
        return bookingClient.useHotelService(latitude, longitude, amount);
    }
}

