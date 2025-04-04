package nl.han.se.bewd.client;

import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BookingApiClient {
    private final IHotelService hotelService;

    @Autowired
    public BookingApiClient(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Map<String, Object>> useHotelService(double latitude, double longitude, int amount) {
        return hotelService.fetchHotels(latitude, longitude, amount);
    }
}