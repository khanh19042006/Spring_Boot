package com.example.demo.Service.OrderService.PaymentService;

public interface IPaymentMethod {
    public void pay(double amount);
    public String getMethodName();
}
