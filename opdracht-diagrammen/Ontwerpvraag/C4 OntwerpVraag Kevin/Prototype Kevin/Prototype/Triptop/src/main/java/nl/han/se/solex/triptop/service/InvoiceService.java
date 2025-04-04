package nl.han.se.solex.triptop.service;

import nl.han.se.solex.triptop.domain.PaymentInfo;
import nl.han.se.solex.triptop.domain.InvoiceInfo;

import java.time.LocalDate;
import java.util.UUID;

public class InvoiceService {
    public InvoiceInfo pay(PaymentInfo paymentInfo) {
        String invoiceNumber = UUID.randomUUID().toString();
        LocalDate date = LocalDate.now();
        String accountNumber = "NL00BANK0123456789";
        String nameOnAccount = "TripTop";

        return new InvoiceInfo(
                invoiceNumber,
                date,
                accountNumber,
                nameOnAccount,
                paymentInfo.getAmount(),
                paymentInfo.getDescription()
        );
    }
}