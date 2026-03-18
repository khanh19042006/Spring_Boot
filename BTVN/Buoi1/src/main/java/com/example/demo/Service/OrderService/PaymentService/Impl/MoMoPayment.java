package com.example.demo.Service.OrderService.PaymentService.Impl;

import com.example.demo.Service.OrderService.PaymentService.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class MoMoPayment implements IPaymentMethod {
    @Override
    public void pay(double amount){
        System.out.println("Đã thanh toán bằng MoMo thành công !");
    }

    @Override
    public String getMethodName(){
        String methodName = "Thanh toán bằng MoMo";
        return methodName;
    }
}
