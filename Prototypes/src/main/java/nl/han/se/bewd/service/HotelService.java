package nl.han.se.bewd.service;



import nl.han.se.bewd.client.BookingApiClient;
import nl.han.se.bewd.domain.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelService {
    private final BookingApiClient bookingClient;

    @Autowired
    public HotelService(BookingApiClient bookingClient) {
        this.bookingClient = bookingClient;
    }

    public List<HotelDTO> getHotels(double latitude, double longitude, int amount) {
        return bookingClient.useHotelService(latitude, longitude, amount);
    }
}

