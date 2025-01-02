package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.models.ErrorDetail;
import org.spring.s009springbootdemo.models.PaymentDetail;
import org.spring.s009springbootdemo.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    /* method-1 : direct using exception handling try-catch*/
//    public ResponseEntity<?> makePayment() {
//        try {
//            PaymentDetail paymentDetail = paymentService.makePayment(100);
//            return ResponseEntity.ok(paymentDetail);
//        } catch (Exception e) {
//            return ResponseEntity.status(400).body(ErrorDetail.of(e.getMessage()));
//        }
//    }
    /* method-2 : using ExceptionControllerAdvice / aspect */
    public ResponseEntity<PaymentDetail> makePayment() {
        PaymentDetail paymentDetail = paymentService.makePayment(100);
        return ResponseEntity.ok(paymentDetail);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetail> processPayment(
            @RequestBody PaymentDetail paymentDetail
    ) {
        logger.info("Payment processed: " + paymentDetail);
        return ResponseEntity.ok(paymentDetail);
    }
}
