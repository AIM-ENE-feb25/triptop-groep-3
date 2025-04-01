package nl.han.se.bewd.prototypetrenadapterpattern;

public class Hotel {
    private String destination;

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void bookHotel() {
        System.out.println("Hotel booked for destination: " + destination);
    }
}
