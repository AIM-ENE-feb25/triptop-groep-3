package nl.han.se.bewd.service;

import nl.han.se.bewd.domain.PaymentInfo;
import nl.han.se.bewd.domain.PaymentType;

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
