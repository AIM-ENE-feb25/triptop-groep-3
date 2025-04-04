package nl.han.se.bewd.controllers;

import nl.han.se.bewd.domain.HotelDTO;
import nl.han.se.bewd.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/amsterdam")
    public List<HotelDTO> getAmsterdamHotels() {
        return hotelService.getHotels(52.377956, 4.897070, 3);
    }

    @GetMapping("/hotels")
    public List<HotelDTO> getHotels(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "3") int amount) {
        return hotelService.getHotels(latitude, longitude, amount);
    }
}