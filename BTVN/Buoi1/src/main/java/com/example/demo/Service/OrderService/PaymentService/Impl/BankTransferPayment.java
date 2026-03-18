package com.example.demo.Service.OrderService.PaymentService.Impl;

import com.example.demo.Service.OrderService.PaymentService.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class BankTransferPayment implements IPaymentMethod   {
    @Override
    public void pay(double amount){
        System.out.println("Thanh toán bằng ngân hàng thành công !");
    }

    @Override
    public String getMethodName(){
        String methodName = "Thanh toán bằng ngân hàng";
        return methodName;
    }
}
