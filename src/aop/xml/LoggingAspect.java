package aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LoggingAspect {




    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " is Begins");

    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " is ends");
    }



    public void afterReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method" + methodName + " ends with " + result);
    }


    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method" + methodName + " has occurs" + ex);


    }



    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {


        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("The Method " + methodName + " begins with" +
                    Arrays.asList(proceedingJoinPoint.getArgs()
                    ));
            result = proceedingJoinPoint.proceed();
            //后置通知
            System.out.println("The Method  " + methodName + " ends with  " + result);
        } catch (Exception e) {
            System.out.println("The method has occurs exception" + e);
            throw new RuntimeException(e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("The method " + methodName + " ends");
        return result;


    }


}
