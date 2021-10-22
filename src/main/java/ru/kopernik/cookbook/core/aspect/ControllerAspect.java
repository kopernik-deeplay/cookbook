package ru.kopernik.cookbook.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(public * ru.kopernik.cookbook.core.rest.controller..*.* (..))")
    public void anyRestControllerMethod() {
        //Здесь ничего не пишем!
    }

    @Before("anyRestControllerMethod()")
    public void beforeCallAnyMethod(JoinPoint jp) {
        Logger log = getLoggerFromJoinPoint(jp);
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("Перед выполнением {}, с аргументами=[ {} ]", jp, args);
    }

    @After("anyRestControllerMethod()")
    public void afterCallAnyMethod(JoinPoint jp) {
        Logger log = getLoggerFromJoinPoint(jp);
        log.info("После выполнением {}", jp);
    }

    @AfterThrowing(value = "anyRestControllerMethod()", throwing = "ex")
    public void afterThrowingAnyException(JoinPoint jp, Exception ex) {
        Logger log = getLoggerFromJoinPoint(jp);
        log.error("Исключение в методе {}", jp, ex);
    }

    private Logger getLoggerFromJoinPoint(JoinPoint jp) {
        return LoggerFactory.getLogger(jp.getTarget().getClass());
    }
}
