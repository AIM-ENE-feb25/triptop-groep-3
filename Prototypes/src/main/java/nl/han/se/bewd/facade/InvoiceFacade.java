package nl.han.se.bewd.facade;

import nl.han.se.bewd.domain.InvoiceInfo;
import nl.han.se.bewd.domain.PaymentInfo;
import nl.han.se.bewd.service.InvoiceService;

public class InvoiceFacade implements PaymentFacade {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    public InvoiceInfo pay(PaymentInfo paymentInfo) {
        return invoiceService.pay(paymentInfo);
    }
}