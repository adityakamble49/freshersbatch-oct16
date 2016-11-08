package com.aditya.spring_aop.time;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectRunner {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "bean.xml");

        Adder adder = (Adder) context.getBean("adder_1");
        adder.addToVector();
        adder.addToList();
    }
}
