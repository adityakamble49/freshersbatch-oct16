package com.aditya.spring_rest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ServiceRunner {

    public static void main(String[] args) {

        SpringApplication.run(ServiceRunner.class, args);
    }
}
