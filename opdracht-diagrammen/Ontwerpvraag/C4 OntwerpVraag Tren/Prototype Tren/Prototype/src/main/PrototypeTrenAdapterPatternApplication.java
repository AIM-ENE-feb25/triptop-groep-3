package nl.han.se.bewd.prototypetrenadapterpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeTrenAdapterPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrototypeTrenAdapterPatternApplication.class, args);
        IHotelService hotelService = new HotelAdapter();
        HotelClient client =  new HotelClient(hotelService);
        client.useHotelService("Amsterdam", 52.377956, 4.897070);

    }

}
