package com.itsc.SpringDemo;

import com.itsc.Contracts.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagingApp {
    public static void main(String[] args) {
    ApplicationContext context = new
            ClassPathXmlApplicationContext("messageconfig.xml");

    MessageService email =  context.getBean("email", MessageService.class);
        email.sendMessage("Emaiiiiiiill");

        MessageService sms =  context.getBean("sms", MessageService.class);
        sms.sendMessage("sms");

        MessageService message =  context.getBean("message", MessageService.class);
        sms.sendMessage("Message");
    }
}
