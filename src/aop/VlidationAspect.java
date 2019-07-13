package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 可以使用@Order（。。）值越小优先级越大
 */
@Order(2)
@Aspect
@Component
public class VlidationAspect {


    @Before("aop.LoggingAspect.declareJointPointExpression()")
    public void vlidationAspect(JoinPoint joinPoint) {
        System.out.println("vlidation:" + Arrays.asList(joinPoint.getArgs()));
    }
}
