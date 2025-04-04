package nl.han.se.solex.triptop.facade;

import nl.han.se.solex.triptop.domain.PaymentInfo;

public interface PaymentFacade {
    Object pay(PaymentInfo paymentInfo);
}