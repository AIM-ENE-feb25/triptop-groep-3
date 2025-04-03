package nl.han.se.bewd.controllers;

import nl.han.se.bewd.adapter.ExternalApiHotelAdapter;
import nl.han.se.bewd.client.BookingAPIClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HotelController {

    private final BookingAPIClient client = new BookingAPIClient(new ExternalApiHotelAdapter());

    @GetMapping("/amsterdam")
    public List<Map<String, Object>> getAmsterdamHotels() {
        return client.useHotelService(52.377956, 4.897070, 3);
    }

    @GetMapping("/hotels")
    public List<Map<String, Object>> getHotels(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "3") int amount) {
        return client.useHotelService(latitude, longitude, amount);
    }
}