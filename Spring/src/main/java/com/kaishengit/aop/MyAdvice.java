package com.kaishengit.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.inject.Named;

/**
 * 通知类
 */


@Named
@Aspect
public class MyAdvice {


   @Pointcut("execution(* com.kaishengit.dao..*.*(..))")
    public void pointcut(){

    }
     /*
    @Before("pointcut()")
    public void before(){

        System.out.println("前置通知。。。。。");
    }
    @AfterReturning(value = "pointcut()",returning = "name")
    public void afer_returning(Object name){
        System.out.println("后置通知。。。。");
    }

    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void exception(Exception e){
        System.out.println("异常通知。。。。");
    }
    @After("pointcut()")
    public void afer(){
        System.out.println("最终通知。。。");
    }*/

    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){

        Object object = null;

        try {
            System.out.println("前置通知。。。");
           object = joinPoint.proceed();//代表了目标对象的执行

            System.out.println("后置通知。。。" + object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知。。。。");
        }finally {
            System.out.println("最终通知。。。。");
        }
        return object;

    }


}
