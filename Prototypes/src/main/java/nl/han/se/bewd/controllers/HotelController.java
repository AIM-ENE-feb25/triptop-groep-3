package nl.han.se.bewd.controllers;

import nl.han.se.bewd.adapter.HotelAdapter;
import nl.han.se.bewd.service.IHotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HotelController {

    private final IHotelService hotelService = new HotelAdapter();

    @GetMapping("/amsterdam")
    public List<Map<String, Object>> getAmsterdamHotels() {
        return hotelService.fetchHotels(52.377956, 4.897070, 3);
    }

    @GetMapping("/hotels")
    public List<Map<String, Object>> getHotels(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam (defaultValue = "3")int amount) {
        List<Map<String, Object>> result = hotelService.fetchHotels(latitude, longitude, amount);
        return result;   }
}