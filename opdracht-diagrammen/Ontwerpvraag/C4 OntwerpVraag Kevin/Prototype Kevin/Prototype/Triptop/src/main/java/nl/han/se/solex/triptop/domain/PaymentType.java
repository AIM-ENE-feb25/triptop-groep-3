package nl.han.se.solex.triptop.domain;

import nl.han.se.solex.triptop.facade.PaymentFacade;
import nl.han.se.solex.triptop.facade.InvoiceFacade;
import nl.han.se.solex.triptop.facade.PaypalFacade;

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
