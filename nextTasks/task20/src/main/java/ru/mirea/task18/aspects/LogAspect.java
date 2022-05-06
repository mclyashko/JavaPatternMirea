package ru.mirea.task18.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class LogAspect {
    @Before("allServiceMethods()")
    public void logParameters() {
        log.info("Time: {}", LocalDateTime.now());
    }
    @Pointcut("within(ru.mirea.task18.services.*)")
    public void allServiceMethods() {}
}
