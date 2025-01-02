package org.spring.main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("execution(* org.spring.services.*.*(..))") // method 1
    @Around("@annotation(org.spring.annotations.ToLog)") // method 2
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
        Object returnedByMethod = joinPoint.proceed(arguments); // not necessary to pass arguments
        logger.info("Method executed and returned " + returnedByMethod);
        return returnedByMethod;
    }
    /* other advices:
    * @Before("execution(* org.spring.services.*.*(..))", pointcut = "nameOfMethod()")
    * @AfterReturning("execution(* org.spring.services.*.*(..))", returning = "nameOfReturnedVariable", pointcut = "nameOfMethod()")
    * @AfterThrowing("execution(* org.spring.services.*.*(..))", throwing = "nameOfException", pointcut = "nameOfMethod()")
    * @After("execution(* org.spring.services.*.*(..))", pointcut = "nameOfMethod()")
    * */
}
