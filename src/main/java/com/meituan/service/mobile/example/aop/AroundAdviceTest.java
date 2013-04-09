package com.meituan.service.mobile.example.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//定义一个切面  
@Aspect
@Component
public class AroundAdviceTest {

    Logger logger = Logger.getLogger(getClass());

    // 匹配 com.wicresoft.app.service.impl 包下所有类的所有方法作为切入点
    @Around("execution(* com.meituan.service.mobile.example.service.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
        logger.info("执行目标方法之前，模拟开始事物...");
        // 执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed(new String[] { "2didTest" });
        logger.info("执行目标方法之前，模拟结束事物...");
        return rvt;
    }

}