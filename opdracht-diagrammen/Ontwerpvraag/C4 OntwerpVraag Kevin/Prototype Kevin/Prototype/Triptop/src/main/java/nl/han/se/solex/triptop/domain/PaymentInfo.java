package nl.han.se.solex.triptop.domain;

public class PaymentInfo {
    private final double amount;
    private final String description;

    public PaymentInfo(double bedrag, String omschrijving) {
        this.amount = bedrag;
        this.description = omschrijving;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}