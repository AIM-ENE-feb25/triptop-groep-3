package nl.han.se.bewd.service;

import nl.han.se.bewd.domain.InvoiceInfo;
import nl.han.se.bewd.domain.PaymentInfo;

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
