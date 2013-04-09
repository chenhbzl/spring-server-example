package com.meituan.mobile.service.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MeituanBeanFactory implements ApplicationContextAware {

    private static volatile ApplicationContext applicationContext;

    private static volatile boolean initByBeanFactory = false;

    private static final Log logger = LogFactory
            .getLog(MeituanBeanFactory.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        logger.debug("init bean factory via setter.");
        applicationContext = ac;
    }

    public static final void init() {
        if (applicationContext == null) {
            synchronized (MeituanBeanFactory.class) {
                if (applicationContext == null) {
                    logger.warn("init bean factory self.");
                    initByBeanFactory = true;
                    applicationContext = new ClassPathXmlApplicationContext(
                            "classpath*:spring/*.xml");
                }
            }
        }
    }

    public static final <T> T getBean(Class<T> clazz) {
        init();
        return applicationContext.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static final <T> T getBean(String beanName) {
        init();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * @return 是否被beanFactory初始化
     */
    public static final boolean initByBeanFactory() {
        return initByBeanFactory;
    }

    /**
     * @return spring是否被初始化
     */
    public static final boolean inited() {
        return applicationContext != null;
    }

    public static void main(String[] args) {
        // System.out.println(MeituanBeanFactory.getBean(PromUserDao.class));

    }

}
