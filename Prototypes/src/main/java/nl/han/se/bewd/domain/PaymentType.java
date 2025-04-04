package nl.han.se.bewd.domain;

import nl.han.se.bewd.facade.InvoiceFacade;
import nl.han.se.bewd.facade.PaymentFacade;
import nl.han.se.bewd.facade.PaypalFacade;

public enum PaymentType {
    PAYPAL(new PaypalFacade()),
    FACTUUR(new InvoiceFacade());

    private final PaymentFacade facade;

    PaymentType(PaymentFacade facade) {
        this.facade = facade;
    }

    public PaymentFacade getFacade() {
        return facade;
    }
}
