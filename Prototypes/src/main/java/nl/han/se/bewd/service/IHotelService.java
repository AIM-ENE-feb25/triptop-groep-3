package nl.han.se.bewd.service;

import java.util.List;
import java.util.Map;

public interface IHotelService {
    List<Map<String, Object>> fetchHotels(double latitude, double longitude, int amount);
}


