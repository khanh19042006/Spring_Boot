package com.example.demo.Service.OrderService;

import com.example.demo.Service.OrderService.NotificationService.INotificationService;
import com.example.demo.Service.OrderService.PaymentService.IPaymentMethod;

public class OrderService {
    private final IPaymentMethod paymentMethod;
    private final INotificationService notificationService;

    public OrderService (IPaymentMethod iPaymentMethod, INotificationService iNotificationService){
        this.notificationService = iNotificationService;
        this.paymentMethod = iPaymentMethod;
    }

    public void processOrder(String customer, String product, double amount){
        paymentMethod.pay(amount);

        String message = product + " đã được thanh toán thành công !";
        notificationService.sendNotification(customer, message);
    }
}
