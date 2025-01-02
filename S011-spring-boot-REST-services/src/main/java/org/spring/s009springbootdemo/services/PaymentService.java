package org.spring.s009springbootdemo.services;

import org.spring.s009springbootdemo.exceptions.NotEnoughMoneyException;
import org.spring.s009springbootdemo.models.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetail makePayment(double amount) {
        throw new NotEnoughMoneyException("Not enough money to make payment");
    }
}
