package com.meituan.service.mobile.example.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdviceTest {

    Logger logger = Logger.getLogger(getClass());

    // 匹配 com.wicresoft.app.service.impl 包下所有类的所有方法作为切入点
    @Before("execution(* com.meituan.service.mobile.example.service.impl.*.*(..))")
    public void authorith() {
        logger.info("模拟进行权限检查。");
    }
}