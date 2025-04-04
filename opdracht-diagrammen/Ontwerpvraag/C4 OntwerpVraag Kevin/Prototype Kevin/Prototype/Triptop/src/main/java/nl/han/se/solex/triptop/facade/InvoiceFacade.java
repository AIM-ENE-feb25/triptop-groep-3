package nl.han.se.solex.triptop.facade;

import nl.han.se.solex.triptop.domain.PaymentInfo;
import nl.han.se.solex.triptop.domain.InvoiceInfo;
import nl.han.se.solex.triptop.service.InvoiceService;

public class InvoiceFacade implements PaymentFacade {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    public InvoiceInfo pay(PaymentInfo paymentInfo) {
        return invoiceService.pay(paymentInfo);
    }
}
