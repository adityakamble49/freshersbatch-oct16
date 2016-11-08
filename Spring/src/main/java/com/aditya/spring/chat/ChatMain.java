package com.aditya.spring.chat;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatMain {

    static AbstractApplicationContext context;

    public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("chat.xml");

        printCharoom("linux_room");
        printCharoom("android_room");

        context.close();
        context.registerShutdownHook();
    }

    public static void printCharoom(String name) {
        System.out.println("Chatroom : " + name);
        Chatroom chatroom = (Chatroom) context.getBean(name);
        chatroom.getUserList().forEach(System.out::println);
        chatroom.getMessageList().forEach(System.out::println);
    }

}
