package com.org.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.org.service.UserServiceimpl.getUser(..))")
    private void p(){};

    @Before("p()")
    public void before()
    {
        System.out.println("before");
    }

    @After("p()")
    public void after()
    {
        System.out.println("after");
    }

    @Around("p()")
    public Object around(ProceedingJoinPoint pjp)
    {
        System.out.println("around before");
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after");
        return obj;
    }

}
