package nl.han.se.bewd.facade;

import nl.han.se.bewd.domain.PaymentInfo;

public interface PaymentFacade {
    Object pay(PaymentInfo paymentInfo);
}