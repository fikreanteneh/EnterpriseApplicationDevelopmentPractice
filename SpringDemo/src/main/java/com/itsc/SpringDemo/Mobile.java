package com.itsc.SpringDemo;

import com.itsc.Contracts.Siminterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("beans.xml");

        Siminterface sim =  context.getBean("sim", Siminterface.class);
        sim.data();
        sim.calling();
    }
}
