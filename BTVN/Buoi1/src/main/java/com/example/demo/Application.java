package com.example.demo;

import com.example.demo.Service.OrderService.NotificationService.Impl.EmailNotification;
import com.example.demo.Service.OrderService.NotificationService.Impl.SmsNotification;
import com.example.demo.Service.OrderService.OrderService;
import com.example.demo.Service.OrderService.PaymentService.Impl.BankTransferPayment;
import com.example.demo.Service.OrderService.PaymentService.Impl.CashPayment;
import com.example.demo.Service.OrderService.PaymentService.Impl.MoMoPayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

// 		DI thủ công, không có Bean
//		OrderService order1 = new OrderService(
//				new BankTransferPayment(),
//				new EmailNotification()
//		);
//
//		OrderService order2 = new OrderService(
//				new MoMoPayment(),
//				new EmailNotification()
//		);
//
//		OrderService order3 = new OrderService(
//				new CashPayment(),
//				new SmsNotification()
//		);

//		Dùng Bean
		BankTransferPayment bank = context.getBean(BankTransferPayment.class);
		MoMoPayment moMo = context.getBean(MoMoPayment.class);
		CashPayment cash = context.getBean(CashPayment.class);

		EmailNotification email = context.getBean(EmailNotification.class);
		SmsNotification sms = context.getBean(SmsNotification.class);

		OrderService order1 = new OrderService(bank, email);
		OrderService order2 = new OrderService(moMo, email);
		OrderService order3 = new OrderService(cash, sms);

		// Test
		order1.processOrder("Nguyên", "Đồng phục học sinh", 2);
		System.out.println();
		order2.processOrder("Linh", "PS5", 1);
		System.out.println();
		order3.processOrder("Khánh", "Skin Yasuo Ma kiếm", 1);
	}

}
