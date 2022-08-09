package com.project.hero.infrastructure.rest.configuration;

import com.codahale.metrics.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class TimedLogAspect {
    private final Timer timer = new Timer();


    @Around("@annotation(com.project.hero.application.annotations.TimedLog)")
    public Object timed(ProceedingJoinPoint joinPoint) throws Throwable {
        Timer.Context context = timer.time();
        StringBuilder stringBuilder = new StringBuilder("The mean rate: ");

        try{
            Object result =joinPoint.proceed();
            finalizeAndLog(context, stringBuilder);
            return result;
        }catch (Exception error){
            finalizeAndLog(context, stringBuilder);
            throw error;
        }
    }

    private void finalizeAndLog(Timer.Context context, StringBuilder stringBuilder){
        context.stop();
        stringBuilder.append(timer.getMeanRate());
        log.debug(stringBuilder.toString());
    }
}
