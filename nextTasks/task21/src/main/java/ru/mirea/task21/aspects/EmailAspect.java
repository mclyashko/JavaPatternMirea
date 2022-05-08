package ru.mirea.task21.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.mirea.task21.services.EmailService;

import javax.annotation.PostConstruct;

@Component
@org.aspectj.lang.annotation.Aspect
public class EmailAspect {

    private final ApplicationContext applicationContext;
    private EmailService emailService;

    @Autowired
    public EmailAspect(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void setEmailService() { this.emailService = applicationContext.getBean(EmailService.class); }

    @Before("saveServiceMethods()")
    public void emailParameters(JoinPoint joinPoint) {
        emailService.sendNotification(joinPoint.getArgs()[0]);
    }

    @Pointcut("@annotation(ru.mirea.task21.annotations.SendMail)")
    public void saveServiceMethods() {}
}
