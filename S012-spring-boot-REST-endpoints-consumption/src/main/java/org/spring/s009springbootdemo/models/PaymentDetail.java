package org.spring.s009springbootdemo.models;

public class PaymentDetail {
    private String id;
    private double amount;

    public static PaymentDetail of(double amount) {
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setAmount(amount);
        return paymentDetail;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
