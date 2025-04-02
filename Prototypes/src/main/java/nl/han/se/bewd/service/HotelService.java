package nl.han.se.bewd.prototypetrenadapterpattern;


public class HotelService {
public void useHotelService( String destination) {
        Hotel hotel = new Hotel();
        hotel.setDestination(destination);
        hotel.bookHotel();
    }
}
