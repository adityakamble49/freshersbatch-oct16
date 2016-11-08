package com.aditya.spring_aop.newuser;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRuner {

    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "usernew.xml");

        UserHandler handler = (UserHandler) context.getBean("user_handler");
        handler.register("aditya", "password", "a", "a");
        handler.login("aditya", "password");
        Thread.sleep(1000);
        try {
            handler.logout();
        } catch (Exception e) {
        }

    }
}
