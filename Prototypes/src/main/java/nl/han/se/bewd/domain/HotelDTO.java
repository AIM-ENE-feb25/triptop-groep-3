package nl.han.se.bewd.domain;


public class HotelDTO {
    private String name;
    private String address;
    private double price;
    private double rating;

    public HotelDTO(String name, String address, double price, double rating) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
}

