package com.example.demo.Service.OrderService.NotificationService.Impl;

import com.example.demo.Service.OrderService.NotificationService.INotificationService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message){
        System.out.println("Message: " + message);
        System.out.println("Thông báo gửi đến " + to + " bằng Email thành công");
    }
}
