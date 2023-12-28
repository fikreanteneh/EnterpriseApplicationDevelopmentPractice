package com.itsc.Models;

import com.itsc.Contracts.MessageService;

public class EmailService  implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("This is a message from Email " + message);

    }
}
