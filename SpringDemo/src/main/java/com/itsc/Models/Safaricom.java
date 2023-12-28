package com.itsc.Models;
import com.itsc.Contracts.*;

public class Safaricom implements Siminterface {
    @Override
    public void calling() {
        System.out.println("System Calling From Safaricom SIM");
    }

    @Override
    public void data() {
        System.out.println("System Browsing From Safaricom SIM");

    }
}
