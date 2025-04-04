package nl.han.se.solex.triptop.service;

import nl.han.se.solex.triptop.domain.PaymentType;
import nl.han.se.solex.triptop.domain.PaymentInfo;

import java.util.Arrays;
import java.util.List;

public class PaymentService {

    public Object pay(PaymentInfo paymentInfo, PaymentType paymentType) {
        return paymentType.getFacade().pay(paymentInfo);
    }

    public List<PaymentType> getPaymentTypes() {
        return Arrays.asList(PaymentType.values());
    }

}