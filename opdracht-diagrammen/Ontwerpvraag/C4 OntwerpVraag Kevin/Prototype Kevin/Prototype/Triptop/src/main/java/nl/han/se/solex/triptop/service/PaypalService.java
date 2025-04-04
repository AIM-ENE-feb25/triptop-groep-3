package nl.han.se.solex.triptop.service;

import nl.han.se.solex.triptop.domain.PaymentInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.json.*;

public class PaypalService {

    private final String MOCK_API_URL = "https://virtserver.swaggerhub.com/KEPOUWELSKP/PayPal/1.0.0";  // SwaggerHub mock API base URL
    private final String PAYMENT_ENDPOINT = "/payments/payment";
    private final String EXECUTE_PAYMENT_ENDPOINT = "/payments/payment/{payment_id}/execute";

    private RestTemplate restTemplate;

    public PaypalService() {
        restTemplate = new RestTemplate();
    }

    public String betaal(PaymentInfo paymentInfo) {
        System.out.println("paypalservicetest");
        // Step 1: Create payment
        String paymentId = createPayment(paymentInfo);

        // Step 2: Get approval link (user would normally get redirected here)
        String approvalLink = getApprovalLink(paymentId);

        // Step 3: Simulate the user approving the payment
        System.out.println("Please approve the payment at: " + approvalLink);

        // Step 4: Execute the payment
        return executePayment(paymentId);
    }

    private String createPayment(PaymentInfo paymentInfo) {
        String url = MOCK_API_URL + PAYMENT_ENDPOINT;

        String requestBody = String.format("{\"amount\": \"%f\", \"currency\": \"EUR\", \"description\": \"%s\"}",
                paymentInfo.getAmount(), paymentInfo.getDescription());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println("Payment created: " + response.getBody());

        JSONObject jsonResponse = new JSONObject(response.getBody());
        return jsonResponse.getString("id");
    }

    private String getApprovalLink(String paymentId) {
        return "https://www.paypal.com/checkoutnow?token=" + paymentId;
    }

    private String executePayment(String paymentId) {
        String url = MOCK_API_URL + EXECUTE_PAYMENT_ENDPOINT;  // Correct URL with path variable

        String requestBody = String.format("{\"payer_id\": \"PAYER-123456\"}");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, paymentId);

        System.out.println("Payment execution response: " + response.getBody());
        return "Payment successfully executed for payment ID: " + paymentId;
    }
}