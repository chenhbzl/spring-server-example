package com.meituan.service.mobile.example.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author zhengxu
 * @created 2013-3-13
 * 
 * @version 1.0
 */
public class ExceptionResolver implements HandlerExceptionResolver,
        ApplicationContextAware {

    private ApplicationContext context;

    Logger logger = Logger.getLogger(getClass());

    ExceptionConverter jsonConverter;

    List<IExceptionAnalysis> exceptionAnalysisList = new ArrayList<IExceptionAnalysis>();

    protected void initExceptionAnalysis() {
        exceptionAnalysisList.addAll(context.getBeansOfType(
                IExceptionAnalysis.class).values());
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception) {
        String packageName = "org.springframework.security";
        if (exception.getClass().getPackage().getName().startsWith(packageName)) {
            return null;
        }
        for (IExceptionAnalysis exceptionAnalysis : exceptionAnalysisList) {
            try {
                exceptionAnalysis.onError(request, exception);
            } catch (Exception e) {
                logger.error("Ops.", e);
            }
        }
        return jsonConverter.convert(request, response, handler, exception);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
        initExceptionAnalysis();
    }

    public void setExceptionConverter(ExceptionConverter exceptionConverter) {
        this.jsonConverter = exceptionConverter;
    }
}
