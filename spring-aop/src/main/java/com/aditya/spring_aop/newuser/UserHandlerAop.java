package com.aditya.spring_aop.newuser;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserHandlerAop {

    private long onlineTime = 0l;

    @Pointcut("execution(* UserHandler.register(..))")
    public void registerCheck() {
    }

    @Pointcut("execution(* UserHandler.login(..))")
    public void loginCheck() {
    }

    @Pointcut("execution(* UserHandler.logout(..))")
    public void logoutCheck() {
    }

    @Around("registerCheck()")
    public Object validateRegistration(ProceedingJoinPoint pjp)
            throws Throwable {
        String username = (String) pjp.getArgs()[0];
        String password = (String) pjp.getArgs()[1];
        if (username.length() < 4 && password.length() < 4) {
            System.out.println(
                    "Username or password is too Short ( Min 3 Char )");
        } else {
            return pjp.proceed();
        }

        return null;
    }

    @AfterThrowing("logoutCheck()")
    public void validateLogout() {
        System.out.println("Exception : Login First");
    }

    @Around("loginCheck()")
    public Object validateLogin(ProceedingJoinPoint pjp) throws Throwable {
        onlineTime = System.currentTimeMillis();
        pjp.proceed();
        return null;
    }

    @After("logoutCheck()")
    public void validateLogoutTime() {
        onlineTime = System.currentTimeMillis() - onlineTime;
        System.out.println("Online Time : " + onlineTime);
    }
}
