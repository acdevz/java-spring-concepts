package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.models.PaymentDetail;
import org.spring.s009springbootdemo.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetail> processPayment(
            @RequestBody PaymentDetail paymentDetail,
            @RequestHeader String requestId
    ) {
        logger.info("Payment of " + paymentDetail.getAmount() + " requested with id " + requestId);
        paymentDetail.setId(UUID.randomUUID().toString());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("requestId", requestId)
                .body(paymentDetail);
    }
}
