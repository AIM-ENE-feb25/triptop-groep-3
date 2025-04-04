package nl.han.se.bewd.service;



import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.client.BookingApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class HotelService {
    private final BookingApiClient bookingClient;

    @Autowired
    public HotelService(BookingApiClient bookingClient) {
        this.bookingClient = bookingClient;
    }

    public List<Map<String, Object>> getHotels(double latitude, double longitude, int amount) {
        return bookingClient.useHotelService(latitude, longitude, amount);
    }
}

