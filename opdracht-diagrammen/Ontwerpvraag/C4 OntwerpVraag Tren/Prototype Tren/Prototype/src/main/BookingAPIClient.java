package nl.han.se.bewd.prototypetrenadapterpattern;

public class BookingAPIClient {
    private final IHotelService hotelService;

    public BookingAPIClient(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void useHotelService(String destination, double latitude, double longitude) {
        hotelService.fetchHotels(latitude, longitude);
    }
}