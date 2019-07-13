package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式
     * @Pointcut来声明表达式
     * 后面的其他通知直接使用方法名直接使用切入点表达式
     */
    @Pointcut("execution(public int aop.jisuanqi.*(..))")
    public void declareJointPointExpression(){

    }


    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " is Begins");

    }

    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " is ends");
    }


    /**
     * @param joinPoint
     */
    @AfterReturning(value = "execution(public int aop.jisuanqi.*(..))", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method" + methodName + " ends with " + result);
    }


    /**
     * 在目标方法出现异常时会执行的代码
     * 可以指定异常类型，只有此种异常才会执行
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJointPointExpression()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method" + methodName + " has occurs" + ex);


    }


    /**
     * 环绕同志需要携带ProceedingJoinPoint类型的参数
     * 环绕同志类似于动态代理的全过程：类型的参数可以决定是否执行目标方法
     * 且环绕通知必须要有返回值，返回值一定为目标方法的返回值
     *
     * @param proceedingJoinPoint
     */
    @Around("declareJointPointExpression()")
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
