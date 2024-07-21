package ru.isands.test.estore.rest.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* ru.isands.test.estore.rest.controller..*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Executing method: {}", joinPoint.getSignature().toShortString());
        logger.info("Arguments: {}", joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "execution(* ru.isands.test.estore.rest.controller..*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in method: {}", joinPoint.getSignature().toShortString());
        logger.error("Exception: ", ex);
    }
}
