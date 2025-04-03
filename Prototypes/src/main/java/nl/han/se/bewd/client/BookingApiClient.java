package nl.han.se.bewd.client;

import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.service.IHotelService;
import java.util.List;
import java.util.Map;

public class BookingApiClient {
    private final IHotelService hotelService;

    public BookingApiClient(ExternalApiHotelAdapter hotelService) {
        this.hotelService = hotelService;
    }

    public List<Map<String, Object>> useHotelService(double latitude, double longitude, int amount) {
        return hotelService.fetchHotels(latitude, longitude, amount);
    }
}