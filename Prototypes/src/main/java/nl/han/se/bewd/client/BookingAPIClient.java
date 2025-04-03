package nl.han.se.bewd.prototypetrenadapterpattern;

import java.util.List;
import java.util.Map;

public class BookingAPIClient {
    private final IHotelService hotelService;

    public BookingAPIClient(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Map<String, Object>> useHotelService( double latitude, double longitude, int amount) {
        return hotelService.fetchHotels(latitude, longitude, amount);
    }
}