package com.volerde.myweb.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * The type Log aspect.
 *
 * @author Volerde
 * @date 2021 /8/16 14:35
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Log.
     */
    @Pointcut("execution(* com.volerde.myweb.controller.*.*(..))")
    public void log(){

    }

    /**
     * Do before.
     *
     * @param joinPoint the join point
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);
        logger.info("RequestLog : {}",requestLog);
    }

    /**
     * Do after.
     */
    @After("log()")
    public void doAfter(){
//        logger.info("=======do after intercept========");
    }

    /**
     * Do after return.
     *
     * @param result the result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    /**
     * The type Request log.
     */
    @Data
    @AllArgsConstructor
    public static class RequestLog{
        private String url;
        private String id;
        private String classMethod;
        private Object[] args;

    }

}
