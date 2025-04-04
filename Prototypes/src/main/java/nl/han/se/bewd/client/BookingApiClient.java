package nl.han.se.bewd.client;

import nl.han.se.bewd.domain.HotelDTO;
import nl.han.se.bewd.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingApiClient {
    private final IHotelService hotelService;

    @Autowired
    public BookingApiClient(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<HotelDTO> useHotelService(double latitude, double longitude, int amount) {
        return hotelService.fetchHotels(latitude, longitude, amount);
    }
}