package nl.han.se.bewd.service;

import nl.han.se.bewd.domain.HotelDTO;

import java.util.List;

public interface IHotelService {
    List<HotelDTO> fetchHotels(double latitude, double longitude, int amount);
}