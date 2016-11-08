package com.aditya.spring.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderMain {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "bean.xml");

        List<Order> orderList = new ArrayList<Order>();

        orderList.add((Order) context.getBean("order_1"));
        orderList.add((Order) context.getBean("order_2"));
        orderList.add((Order) context.getBean("order_3"));

        System.out.println(orderList.stream().map(o -> o.getItem().getPrice())
                .collect(Collectors.summingDouble(d -> d)));

        context.close();
        context.registerShutdownHook();
    }

}
