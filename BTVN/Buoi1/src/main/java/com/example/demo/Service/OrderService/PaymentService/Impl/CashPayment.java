package com.example.demo.Service.OrderService.PaymentService.Impl;

import com.example.demo.Service.OrderService.PaymentService.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CashPayment implements IPaymentMethod {
    @Override
    public void pay(double amount){
        System.out.println("Thanh toán bằng tiền mặt thành công !");
    }

    @Override
    public String getMethodName(){
        String methodName = "Thanh toán bằng tiền mặt";
        return methodName;
    }
}
