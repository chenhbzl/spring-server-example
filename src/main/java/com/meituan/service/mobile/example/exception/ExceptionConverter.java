package com.meituan.service.mobile.example.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ExceptionConverter {

    public ModelAndView convert(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception);
}
