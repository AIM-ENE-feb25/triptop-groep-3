package nl.han.se.solex.triptop.controllers;

import nl.han.se.solex.triptop.domain.PaymentType;
import nl.han.se.solex.triptop.domain.PaymentInfo;
import nl.han.se.solex.triptop.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController() {
        this.paymentService = new PaymentService(); // Of via @Autowired met @Service
    }

    @PostMapping("pay")
    public Object pay(@RequestBody PaymentInfo paymentInfo,
                      @RequestParam PaymentType paymentType) {
        return paymentService.pay(paymentInfo, paymentType);
    }

    @GetMapping("/available-paymenttypes")
    public List<PaymentType> showAvailablePaymentTypes() {
        return paymentService.getPaymentTypes();
    }
}