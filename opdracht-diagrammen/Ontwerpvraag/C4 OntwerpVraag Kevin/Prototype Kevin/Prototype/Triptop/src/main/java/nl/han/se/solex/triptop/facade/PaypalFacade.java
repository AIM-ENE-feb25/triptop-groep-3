package nl.han.se.solex.triptop.facade;

import nl.han.se.solex.triptop.domain.PaymentInfo;
import nl.han.se.solex.triptop.service.PaypalService;

public class PaypalFacade implements PaymentFacade {

    private final PaypalService paypalService = new PaypalService();

    @Override
    public String pay(PaymentInfo paymentInfo) {
        return paypalService.betaal(paymentInfo);
    }
}