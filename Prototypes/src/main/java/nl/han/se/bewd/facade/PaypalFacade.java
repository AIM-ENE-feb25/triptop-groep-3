package nl.han.se.bewd.facade;

import nl.han.se.bewd.domain.PaymentInfo;
import nl.han.se.bewd.service.PaypalService;

public class PaypalFacade implements PaymentFacade {

    private final PaypalService paypalService = new PaypalService();

    @Override
    public String pay(PaymentInfo paymentInfo) {
        return paypalService.betaal(paymentInfo);
    }
}