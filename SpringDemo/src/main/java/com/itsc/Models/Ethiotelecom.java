package com.itsc.Models;

import com.itsc.Contracts.*;

public class Ethiotelecom implements Siminterface {
    @Override
    public void calling() {
        System.out.println("System Calling From Ethiotelecom SIM");
    }

    @Override
    public void data() {
        System.out.println("System Browsing From Ethiotelecom SIM");

    }
}
