package com.aditya.spring_aop.time;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdderAspect {

    @Pointcut("execution(* Adder.*(..))")
    public void anyMethodPointcut() {
    }

    @Around("anyMethodPointcut()")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
        Long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long end = System.currentTimeMillis();
        System.out
                .println(pjp.getSignature() + " Time Taken : " + (end - start));
        return result;
    }
}
