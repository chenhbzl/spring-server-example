package com.meituan.service.mobile.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("accessLoggerInterceptor")
public class AccessLoggerInterceptor extends HandlerInterceptorAdapter
        implements Ordered {

    Logger logger = Logger.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        logger.info(request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    int order = 100000;

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
