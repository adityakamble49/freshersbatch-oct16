package com.aditya.spring.life;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeMain {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "life.xml");

        Life life = (Life) context.getBean("life_1");

        context.close();
        context.registerShutdownHook();
    }

}
